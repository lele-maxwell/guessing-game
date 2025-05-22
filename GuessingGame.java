import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {

        Scanner prompt = new Scanner(System.in);
        System.out.println("\n🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩");
        System.out.println(" ================================================================================= ");
        System.out.println(" |🍁              🎮🎮🎮  GUESSING GAME 🎮🎮🎮                                  🍁 | ");
        System.out.println(" ================================================================================= ");
        System.out.println("\n🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲\n");

        System.out.println(
                "\n 🤓Hello ..🖐️ Welcome to the  guessing game World! \n\n 🤔 Hmm... I am thinking of a random number. Try to guess it! ");

        System.out.println("\n⚙️  Enter game difficulty: \n 🔫Easy \n 🔫Normal \n 🔫Hard\n");
        System.out.println("\n🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮\n");

        System.out.println("......... [ You got 5 ❤️❤️❤️❤️❤️ lives throughout the game! ] .........");

        int lifes = 5;
        String difficulty = prompt.nextLine();
        Random rand = new Random();
        long score = 1000;

        int range = 10;
        int computer = 0;

        switch (difficulty) {
            case "Easy":
                computer = rand.nextInt(10) + 1;
                range = 10;
                break;
            case "Normal":
                computer = rand.nextInt(100) + 1;
                range = 100;
                break;
            case "Hard":
                computer = rand.nextInt(200) + 1;
                range = 200;
                break;
            default:
                System.out.println("Invalid choice! Please restart the game and select a valid difficulty.");
                return;
        }

        System.out.println("\nChoose Game Mode:");
        System.out.println("1. Single Player 🎯");
        System.out.println("2. Local Multiplayer 🤝");
        String gameMode = prompt.nextLine();

        System.out.println(".............Range: [ 1 -> " + range + " ]....................... ");
        System.out.println(".............Life [❤️ " + lifes + "]...................");
        System.out.println("\n...........Game starting:... \n");
        System.out.println(".............⏳Loading #########/........50%");
        System.out.println(".............⏳Loading ##################100%");
        System.out.println("📢📢PLAY📢📢\n");

        if (gameMode.equals("1")) {
            // Single Player mode
            singlePlayerMode(prompt, computer, lifes, score);
        } else if (gameMode.equals("2")) {
            // Multiplayer mode
            System.out.println("Enter Player 1 Name:");
            String player1 = prompt.nextLine();
            System.out.println("Enter Player 2 Name:");
            String player2 = prompt.nextLine();
            multiplayerMode(prompt, computer, lifes, score, player1, player2);
        } else {
            System.out.println("Invalid choice! Please restart the game.");
        }

        System.out.println("\n🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮");
    }

    public static void singlePlayerMode(Scanner prompt, int computer, int lifes, long score) {
        long startTime = System.currentTimeMillis();
        int user_guess = prompt.nextInt();

        while (user_guess != computer && lifes > 1) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = ((currentTime - startTime) / 1000) / 60;

            lifes -= 1;
            score -= 200;
            if (user_guess < computer) {
                System.out.println("......😵‍💫 ❌ Your number is lesser. Try again! ");
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            } else if (user_guess > computer) {
                System.out.println("..........😵‍💫 ❌ Your number is greater. Try again! ");
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            } else if (elapsedTime > 60) {
                break;
            }
            user_guess = prompt.nextInt();
        }

        if (user_guess == computer) {
            System.out.println("\n🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆 Congratulations, you won! 🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆");
            System.out.println("\n SCORE : " + score + "/1000");
        } else {
            System.out.println("\n.........You Lose 🤕 ❌❌ The correct number was: " + computer + ".......");
            System.out.println("\n SCORE : " + score + "/1000");
        }
    }

    public static void multiplayerMode(Scanner prompt, int computer, int lifes, long score, String player1, String player2) {
        long startTime = System.currentTimeMillis();
        int currentPlayer = 1;
        int user_guess;

        while (lifes > 0) {
            String currentPlayerName = (currentPlayer == 1) ? player1 : player2;
            System.out.println(currentPlayerName + "'s Turn! 🎮 Guess the number:");

            user_guess = prompt.nextInt();
            long currentTime = System.currentTimeMillis();
            long elapsedTime = ((currentTime - startTime) / 1000) / 60;

            if (user_guess == computer) {
                System.out.println("\n🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆 Congratulations, " + currentPlayerName + " won! 🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆");
                System.out.println("\n SCORE : " + score + "/1000");
                return;
            } else {
                lifes -= 1;
                score -= 200;
                if (user_guess < computer) {
                    System.out.println("......😵‍💫 ❌ Your number is lesser. Try again! ");
                } else {
                    System.out.println("..........😵‍💫 ❌ Your number is greater. Try again! ");
                }
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            }

            if (elapsedTime > 2) {
                System.out.println("\n⏳ Time's up!");
                break;
            }

            // Switch player
            currentPlayer = (currentPlayer == 1) ? 2 : 1;
        }

        System.out.println("\n.........Game Over ❌ No one guessed the number. The correct number was: " + computer + ".......");
        System.out.println("\n SCORE : " + score + "/1000");
    }
}
