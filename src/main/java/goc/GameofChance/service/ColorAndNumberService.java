package goc.GameofChance.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ColorAndNumberService {
    public String play() {
        Random random = new Random();

        String[] colors = {"kırmızı", "siyah"};
        String randomColor = colors[random.nextInt(colors.length)];

        int randomNumber = random.nextInt(37);

        String result;

        boolean isRed = randomColor.equals("kırmızı");
        boolean isEven = randomNumber % 2 == 0;

        if (isRed && isEven) {
            result = "Mükemmel! Kazandınız. Renk: Kırmızı, Sayı: " + randomNumber;
        } else if (!isRed && !isEven) {
            result = "Mükemmel! Kazandınız. Renk: Siyah, Sayı: " + randomNumber;
        } else if (isRed && !isEven) {
            result = "Renk Kazandı ! Renk: Kırmızı, Sayı kaybetti ! Sayı: " + randomNumber;
        } else {
            result = "Sayı Kazandı! Sayı: " + randomNumber + ", Renk kaybetti ! Renk: Kırmızı.";
        }

        return result;

    }
}
