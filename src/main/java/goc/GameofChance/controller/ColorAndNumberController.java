package goc.GameofChance.controller;

import goc.GameofChance.model.ColorAndNumberDto;
import goc.GameofChance.service.ColorAndNumberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colorAndNumberGuess")
public class ColorAndNumberController {
    private ColorAndNumberService colorAndNumberService;

    public ColorAndNumberController(ColorAndNumberService colorAndNumberService) {
        this.colorAndNumberService = colorAndNumberService;
    }

    @PostMapping("/play")
    public ResponseEntity<String> playGame(@RequestBody ColorAndNumberDto selection) {
        String result = colorAndNumberService.play();
        return ResponseEntity.ok(result);
    }
}
