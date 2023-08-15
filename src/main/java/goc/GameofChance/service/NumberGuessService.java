package goc.GameofChance.service;

import goc.GameofChance.model.NumberGuessDto;
import goc.GameofChance.model.NumberGuessModel;
import org.springframework.stereotype.Service;

@Service
public class NumberGuessService {
    private NumberGuessModel gameModel;

    public NumberGuessService() {
        this.gameModel = new NumberGuessModel();
    }

    public String makeGuess(NumberGuessDto guessDTO) {
        int guess = guessDTO.getGuess();
        String result;

        if (guess < 1 || guess > 20) {
            result = "Geçersiz tahmin. 1 ile 50 arasında bir tahmin yapın.";
        } else {
            if (gameModel.makeGuess(guess)) {
                result = "Tebrikler! " + guess + " doğru tahmin.";
            } else {
                result = guess + " yanlış tahmin. Kalan hakkınız: " + (5 - gameModel.getUserGuesses());
            }
        }

        if (gameModel.getCorrectGuesses() == 3) {
            int kazanc = gameModel.getTargetNumber() * 2;
            result += "\n3 doğru tahmin! Kazancınız: " + kazanc;
        } else if (gameModel.isGameFinished()) {
            result += "\nÜzgünüz, kazanamadınız. Doğru cevap: " + gameModel.getTargetNumber();
        }

        return result;
    }
}
