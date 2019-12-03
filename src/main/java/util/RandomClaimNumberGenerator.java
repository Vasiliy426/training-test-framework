package util;

import java.util.Random;

public class RandomClaimNumberGenerator {

    public String generate() {
        Random rand = new Random();
        return "AX2018-" + String.valueOf(100_000_000 + rand.nextInt(100_000_000)).substring(1); // removes one leading digit
    }
}
