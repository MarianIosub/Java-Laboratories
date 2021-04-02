package com.company;

import java.util.ArrayList;
import java.util.List;
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
        Integer chosenToken=-1;
        int playerIndex = 0;
        Scanner scanner = new Scanner(System.in);
        while (!board.getBoard().isEmpty()) {
            board.printBoard();
            System.out.println("This round will move " + players.get(playerIndex).getName());
            System.out.print("Please input the number of the token: ");
            boolean chosen = false;
            while (!chosen) {
                chosenToken = scanner.nextInt();
                if (chosenToken > board.getBoard().size()-1) {
                    System.out.print("The input doesn't exist! Try again:");

                }else{
                    chosen = true;
                }
            }
            System.out.println("You have chosen the token: "+ board.getBoard().get(chosenToken));
            players.get(playerIndex).addToken(board.getBoard().get(chosenToken));
            board.getBoard().remove(board.getBoard().get(chosenToken));
            board.setNoOfTokens(board.getNoOfTokens()-1);
            if(playerIndex==players.size()-1){
                playerIndex=0;
            }else{
                playerIndex++;
            }
            System.out.println("\n\n\n");

        }
        Player winner=new Player("Winner");
        for(Player player:players){
            if(player.getScore()>winner.getScore()){
                winner.setScore(player.getScore());
                winner.setName(player.getName());
            }
        }
        System.out.println("The winner is " + winner.getName() + " with the score: " + winner.getScore() );
    }
}
