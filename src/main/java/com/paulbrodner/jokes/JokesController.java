package com.paulbrodner.jokes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JokesController {

    @Autowired
    JokeRepository jokeRepository;

    @GetMapping("/joke")
    @ResponseBody
    public Joke sayJoke(@RequestParam(name = "category", required = false, defaultValue = "it") String name) {
        return jokeRepository.getRandomJoke();
    }
}
