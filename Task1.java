import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MAX_ATTEMPTS = 5;
    private static int roundsWon = 0;
    private static int totalRounds = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
       
        while (true) {
            int numberToGuess = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int attemptsLeft = MAX_ATTEMPTS;
            boolean hasGuessedCorrectly = false;
           
            System.out.println("A new number has been generated. Guess the number between 1 and 100.");
           
            while (attemptsLeft > 0 && !hasGuessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
               
                if (userGuess < 1 || userGuess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }
               
                if (userGuess == numberToGuess) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    hasGuessedCorrectly = true;
                    roundsWon++;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
               
                attemptsLeft--;
                if (attemptsLeft > 0 && !hasGuessedCorrectly) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }
           
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The number was: " + numberToGuess);
            }
           
            totalRounds++;
           
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
           
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
       
        scanner.close();
        System.out.println("Game over. You won " + roundsWon + " out of " + totalRounds + " rounds.");
    }
}
