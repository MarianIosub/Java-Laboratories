package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Integer noOfTokens;
    private List<Token> board = new ArrayList<>();

    public Board(Integer noOfTokens) {
        this.noOfTokens = noOfTokens;
        for (int tokenIndex = 0; tokenIndex < noOfTokens; tokenIndex++) {
            Token token = new Token(noOfTokens);
            board.add(token);
        }
    }

    public void printBoard() {
        System.out.println("The board has " + noOfTokens + " tokens.");
        for (Token token : board) {

            System.out.print(board.indexOf(token) + ": ");
            System.out.println(token);
        }

    }

    public List<Token> getBoard() {
        return board;
    }

    public Integer getNoOfTokens() {
        return noOfTokens;
    }

    public void setNoOfTokens(Integer noOfTokens) {
        this.noOfTokens = noOfTokens;
    }
}
