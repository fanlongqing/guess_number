package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GameServiceTest {

    @Test
    public void should_return_result_when_guess_number(){
        GuessNumberGame guessNumberGame= Mockito.mock(GuessNumberGame.class);
        GameService gameService=new GameService(guessNumberGame);

        gameService.guess("1 2 3 4");

        Mockito.verify(guessNumberGame, Mockito.times(1)).guess("1 2 3 4");
    }
}
