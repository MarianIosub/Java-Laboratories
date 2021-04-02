package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Token> tokens=new ArrayList<>();
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void addToken(Token token){
        tokens.add(token);
    }
    public int getScore(){

        for(Token token:tokens){
            score+=token.getScoreValue();
        }
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }
}