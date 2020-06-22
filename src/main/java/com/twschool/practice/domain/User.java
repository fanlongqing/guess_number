package com.twschool.practice.domain;

public class User {
    private String id;
    private int winTimes;
    private int score;
    private GuessNumberGame guessNumberGame;
    public User(String id, int winTimes,int score,GuessNumberGame guessNumberGame) {
        this.id = id;
        this.winTimes = winTimes;
        this.score = score;
        this.guessNumberGame=guessNumberGame;
    }
    public void addScore(int score) {
        this.score += score;
    }
    public void addWinTimes() {
        this.winTimes++;
    }
    public void initWinTimes() {
        this.winTimes = 0;
    }
    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void setGuessNumberGame(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getWinTimes() {
        return winTimes;
    }

    public void setWinTimes(int winTimes) {
        this.winTimes = winTimes;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
