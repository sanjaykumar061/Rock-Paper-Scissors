package rockpaperscissors;

import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] choices = {"rock", "paper", "scissors"};

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Enter your choice: rock, paper, or scissors");

        while (true) {
            String playerChoice = scanner.next().toLowerCase();
            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice! Please enter rock, paper, or scissors.");
                continue;
            }

            String computerChoice = getRandomChoice(choices);
            System.out.println("Computer chose: " + computerChoice);
            System.out.println(compareChoices(playerChoice, computerChoice));
            System.out.println("Do you want to play again? (yes/no)");

            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        System.out.println("Thank you for playing!");
    }

    public static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    public static String getRandomChoice(String[] choices) {
        int randomIndex = (int) (Math.random() * choices.length);
        return choices[randomIndex];
    }

    public static String compareChoices(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}

