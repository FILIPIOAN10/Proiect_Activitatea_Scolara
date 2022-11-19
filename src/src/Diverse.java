package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Diverse {
    // metoda pentru a genera parola

    // statice
    public static String generatePassword() {
        Random random = new Random();
        String alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz";
        String alphabetUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0987654321";
        String specialChars = "!@#$%^&*+-";
        String allCharacters = alphabetLowerCase + alphabetUpperCase + digits + specialChars;

        List<Character> passwordChars = new ArrayList<>();
        passwordChars.add(alphabetLowerCase.charAt(random.nextInt(alphabetLowerCase.length())));
        passwordChars.add(alphabetUpperCase.charAt(random.nextInt(alphabetUpperCase.length())));
        passwordChars.add(digits.charAt(random.nextInt(digits.length())));
        passwordChars.add(specialChars.charAt(random.nextInt(specialChars.length())));

        int minLength = 2;
        int maxLength = 8;
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        for(int i=0; i<length; i++) {
            passwordChars.add(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        Collections.shuffle(passwordChars);
        StringBuilder password = new StringBuilder();
        for(char ch : passwordChars) {
            password.append(ch);
        }
        return password.toString();
    }

}
