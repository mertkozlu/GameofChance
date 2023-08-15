package goc.GameofChance.controller;

import goc.GameofChance.model.NumberGuessDto;
import goc.GameofChance.service.NumberGuessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numberGuess")
public class NumberGuessController {
    private NumberGuessService gameService;


    public NumberGuessController(NumberGuessService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/play")
    public ResponseEntity<String> makeGuess(@RequestBody NumberGuessDto guessDTO) {
        String result = gameService.makeGuess(guessDTO);
        return ResponseEntity.ok(result);
    }
}
