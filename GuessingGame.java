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

        System.out.println("\n⚙️  Enter game difficulty: \n 🔫1. Easy \n 🔫2. Normal \n 🔫3. Hard\n");
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

        System.out.println(".............Range: [ 1 -> " + range + " ]....................... ");
        System.out.println(".............Life [❤️ " + lifes + "]...................");
        System.out.println("\n...........Game starting:... \n");
        System.out.println(".............⏳Loading #########/........50%");
        System.out.println(".............⏳Loading ##################100%");
        System.out.println("📢📢PLAY📢📢\n");

        long startTime = System.currentTimeMillis();
        int user_guess = prompt.nextInt();
        while (user_guess != computer && lifes > 0) { 

            long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; 

            if (elapsedTime > 60) {
                System.out.println("\n⏰ Time's up! You took more than 1 minute.");
                break;
            }

            lifes -= 1;
            score -= 200;

            if (user_guess < computer) {
                System.out.println("......😵‍💫 ❌ Your number is lesser. Try again! ");
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            } else if (user_guess > computer) {
                System.out.println("..........😵‍💫 ❌ Your number is greater. Try again! ");
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            }

            if (lifes == 0) {
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

        System.out.println("\n🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮");
    }
}
