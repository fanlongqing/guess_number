package com.twschool.practice.controller;

import com.twschool.practice.dao.UserRepository;
import com.twschool.practice.domain.AnswerGenerator;
import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.User;
import com.twschool.practice.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {
    @Autowired
    private UserRepository userRepository;
    private GameService gameService;
    @PostMapping("/games/guess-numbers")
    public Map<String,String> guess(@RequestBody Map<String,String> requestBody){
        User user = userRepository.getUserById(requestBody.get("userId"));
        if (user == null) {
            GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerGenerator());
            user = new User(requestBody.get("userId"),0, 0,guessNumberGame);
            userRepository.setUserInfo(requestBody.get("userId"), user);
        } else {
            if (user.getGuessNumberGame().getStatus() != GameStatus.CONTINUED) {
                user.setGuessNumberGame(new GuessNumberGame(new AnswerGenerator()));
            }
        }
        gameService = new GameService(user);
        Map<String, String> map = new HashMap<>();
        map.put("input", requestBody.get("number"));
        map.put("output", gameService.guess(requestBody.get("number")));
        map.put("score", gameService.countScore() + "");
        return map;
    }

}


