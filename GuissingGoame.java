import java.util.*;

public class GuissingGoame {
    public static void main(String[] args) {

        Scanner promt = new Scanner(System.in);
        System.out.println("\n🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩🧩");
        System.out.println(" ================================================================================= ");
        System.out.println(" |🍁              🎮🎮🎮  GUESSING GAME 🎮🎮🎮                                  🍁 | ");
        System.out.println(" ================================================================================= ");
        System.out.println("\n🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲🎲\n");

        System.out.println("\n 🤓Hello ..🖐️ Welcome to the  guessing game World! \n\n 🤔 Hmm... I am thinking of a random number. Try to guess it! ");

        System.out.println("\n⚙️  Enter game difficulty: \n 🔫1. Easy \n 🔫2. Normal \n 🔫3. Hard\n");
        System.out.println("\n🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮🎮\n");

        System.out.println("......... [ You got 5 ❤️❤️❤️❤️❤️ lives throughout the game! ] .........");

        int lifes = 5;
        String difficulty = promt.nextLine();
        Random rand = new Random();

        int range = 10;
        int computer = 0;

        switch (difficulty) {
            case "Easy":
                computer = rand.nextInt(10) + 1; // Random between 1 and 10
                range = 10;
                break;
            case "Normal":
                computer = rand.nextInt(100) + 1; // Random between 1 and 100
                range = 100;
                break;
            case "Hard":
                computer = rand.nextInt(200) + 1; // Random between 1 and 200
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

        int user_guess = promt.nextInt();
        while (user_guess != computer && lifes > 1) {
            lifes -= 1;
            if (user_guess < computer) {
                System.out.println("......😵‍💫 ❌ Your number is lesser. Try again! ");
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            } else if (user_guess > computer) {
                System.out.println("..........😵‍💫 ❌ Your number is greater. Try again! ");
                System.out.println(".......Life [: ❤️ " + lifes + "].........");
            }
            user_guess = promt.nextInt();
        }

        if (user_guess == computer) {
            System.out.println("\n🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆 Congratulations, you won! 🏆🏆🏆🏆🏆🏆🏆🏆🏆🏆");
        } else {
            System.out.println("\n.........You Lose 🤕 ❌❌ The correct number was: " + computer + ".......");
        }

        System.out.println("\n🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮🧮");
    }
}
