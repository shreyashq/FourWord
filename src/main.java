package src;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;

public class main {

    public static void main(String[] args) {

        String filePath = "src/words.txt";

        try {
            // Count total number of words (lines)
            long totalWords = Files.lines(Paths.get(filePath)).count();

            // Generate a random index
            int randomIndex = ThreadLocalRandom.current().nextInt((int) totalWords);

            // Read the word at the random index
            String randomWord = Files.lines(Paths.get(filePath))
                    .skip(randomIndex)
                    .findFirst()
                    .orElse("No word found!");

            System.out.println("We have selected a 5 letter word, try to guess it in 5 guesses: ");
            Scanner sc = new Scanner(System.in);
            int userWin = 0;
            int guessCount = 5;

            while (userWin != 1) {
                System.out.println();
                String userInput = sc.next();

                // Check if the word is 4 letters long
                if (userInput.length() != 5) {
                    System.out.println("Invalid input! Please enter a word with exactly 5 letters.");
                    continue;
                }

                if (randomWord.equals(userInput)) {
                    System.out.println();
                    System.out.println("You win!!");
                    userWin = 1;
                } else {
                    System.out.println();
                    System.out.println("Try again: ");

                    // Hint 1: Correct letters in correct positions
                    System.out.print("The letters you see below are at their correct index: ");
                    for (int i = 0; i < userInput.length(); i++) {
                        if (userInput.charAt(i) == randomWord.charAt(i)) {
                            System.out.print(userInput.charAt(i));
                        } else {
                            System.out.print("_");
                        }
                    }
                    System.out.println();

                    // Hint 2: Letters in the word but not at correct index
                    System.out.print("Letters in the word but not at the correct index: ");
                    for (int i = 0; i < userInput.length(); i++) {
                        char userChar = userInput.charAt(i);
                        if (randomWord.contains(String.valueOf(userChar)) && randomWord.charAt(i) != userChar) {
                            System.out.print(userChar + " ");
                        }
                    }
                    System.out.println();

                    // Decrease guesses
                    guessCount--;
                    if (guessCount == 0) {
                        System.out.println();
                        System.out.println("You lost...");
                        userWin = 1;
                    }
                }
            }

            System.out.println("The word was: " + randomWord);
            System.out.println();
            System.out.println("To play again, simply rerun the program.");
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
