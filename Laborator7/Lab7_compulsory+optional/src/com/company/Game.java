package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
    public void startGame() {
        final Integer[] chosenToken = {-1};
        final int[] playerIndex = {0};
        Scanner scanner = new Scanner(System.in);
        while (!board.getBoard().isEmpty()) {
            Runnable playerTask = new Runnable() {
                @Override
                public void run() {


                    board.printBoard();

                    System.out.println("This round will move " + players.get(playerIndex[0]).getName() + " who has the tokens: " + players.get(playerIndex[0]).getTokens());
                    if (!players.get(playerIndex[0]).isBot()) {
                        System.out.print("Please input the number of the token: ");
                        boolean chosen = false;
                        while (!chosen) {
                            chosenToken[0] = scanner.nextInt();
                            if (chosenToken[0] > board.getBoard().size() - 1) {
                                System.out.print("The input doesn't exist! Try again:");

                            } else {
                                chosen = true;
                            }
                        }
                    }else{
                        Random random=new Random();
                        chosenToken[0]= random.nextInt(board.getBoard().size());
                    }
                    System.out.println("You have chosen the token: " + board.getBoard().get(chosenToken[0]));
                    players.get(playerIndex[0]).addToken(board.getBoard().get(chosenToken[0]));
                    board.getBoard().remove(board.getBoard().get(chosenToken[0]));
                    board.setNoOfTokens(board.getNoOfTokens() - 1);
                    if (playerIndex[0] == players.size() - 1) {
                        playerIndex[0] = 0;
                    } else {
                        playerIndex[0]++;
                    }
                    System.out.println("\n\n\n");
                }
            };
            Thread thread = new Thread(playerTask);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Player winner = new Player("Winner");
        for (Player player : players) {
            if (player.getScore() > winner.getScore()) {
                winner.setScore(player.getScore());
                winner.setName(player.getName());
            }
        }
        System.out.println("The winner is " + winner.getName() + " with the score: " + winner.getScore());
    }
}
