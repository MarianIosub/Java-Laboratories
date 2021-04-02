package com.company;

public class Main {

    public static void main(String[] args) {
	Board board=new Board(10);
        board.printBoard();

    Player firstPlayer=new Player("Mirel");
    Player secondPlayer=new Player("Marcel");
    Player thirdPlayer=new Player("Viorel");
    Player fourthPlayer=new Player("Mitica");
    Game game=new Game(board);
    game.addPlayer(firstPlayer);
    game.addPlayer(secondPlayer);
    game.addPlayer(thirdPlayer);
    game.addPlayer(fourthPlayer);
    game.startGame();
    }
}
