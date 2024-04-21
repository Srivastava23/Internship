import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int secretNumber = random.nextInt(20) + 1; // Generate a random number between 1 and 100
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the secret number between 1 and 20.");

        System.out.print("Enter your guess: ");
        int guess = scanner.nextInt();

        if (guess == secretNumber) {
            System.out.println("Congratulations! You've guessed the correct number.");
        } else {
            System.out.println("Sorry, you didn't guess the correct number. The correct number was: " + secretNumber);
        }

        scanner.close();
    }
}
