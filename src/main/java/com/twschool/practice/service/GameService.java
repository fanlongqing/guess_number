package com.twschool.practice.service;

import com.twschool.practice.domain.GameAnswer;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.User;

import java.util.Arrays;
import java.util.List;

public class GameService {
    private GuessNumberGame guessNumberGame;
    private User user;

    public GameService(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public String  guess(String userAnswerString) {
        GameAnswer userAnswer = new GameAnswer(userAnswerString);
        if (!userAnswer.isValidFormat()) {
            return "输入错误，请输入";
        }
        return guessNumberGame.guess(userAnswerString);

    }

    public int countScore() {
        if (guessNumberGame.getStatus() == GameStatus.FAILED) {
            user.addScore(-3);
            user.initWinTimes();

        } else if (guessNumberGame.getStatus() == GameStatus.SUCCEED) {
            user.addScore(3);
            user.addWinTimes();
            if(user.getWinTimes()%5==0){
                user.addScore(3);
            }else if(user.getWinTimes()%3==0){
                user.addScore(2);
            }
        }
        return user.getScore();
    }

}
