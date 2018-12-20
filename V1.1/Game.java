
import java.util.Scanner;

public class Game {

    int level = 1;
    public Level currentLevel;
    Player[] players;

    Character Charizard;
    Character Blaitoise;
    Character Venusaur;
    Character Pikachu;

    public Game() {
        Charizard = new Character("Charizard", 2, 9, 1);
        Blaitoise = new Character("Blaitoise", 2, 8, 2);
        Venusaur = new Character("Venusaur", 2, 6, 5);
        Pikachu = new Character("Pikachu", 1, 10, 4);
    }

    public void startGame() {
        // Beautiful ASCII art
        System.out.println("  .:XHHHHk.              db.   .;;.     dH  MX   0");
        System.out.println("oMMMMMMMMMMM       ~MM  dMMP :MMMMMR   MMM  MR      ~MRMN");
        System.out.println("QMMMMMb  \"MMX       MMMMMMP !MX' :M~   MMM MMM  .oo. XMMM 'MMM");
        System.out.println("  `MMMM.  )M> :X!Hk. MMMM   XMM.o\"  .  MMMMMMM X?XMMM MMM>!MMP");
        System.out.println("   'MMMb.dM! XM M'?M MMMMMX.`MMMMMMMM~ MM MMM XM `\" MX MMXXMM");
        System.out.println("    ~MMMMM~ XMM. .XM XM`\"MMMb.~*?**~ .MMX M t MMbooMM XMMMMMP");
        System.out.println("     ?MMM>  YMMMMMM! MM   `?MMRb.    `\"\"\"   !L\"MMMMM XM IMMM");
        System.out.println("      MMMX   \"MMMM\"  MM       ~%:           !Mh.\"\"\" dMI IMMP");
        System.out.println("      'MMM.                                             IMX");
        System.out.println("       ~M!M                                             IMP");

        System.out.println("\033[1;33mHello! Welcome to the RPG Battle Game!\033[0m");

        Scanner scanner = new Scanner(System.in);
        players = new Player[2];

        // Determine the specs of Player 1
        System.out.print("Enter the name of Player 1: ");
        String playerNameP1 = scanner.nextLine();

        System.out.println("@ Character list @");
        System.out.println("1. Charizard (Attacks: 2, Attack Power: 10, Defense Power: 0)");
        System.out.println("2. Blaitoise (Attacks: 2, Attack Power: 8, Defense Power: 1)");
        System.out.println("3. Venusaur (Attacks: 2, Attack Power: 5, Defense Power: 2)");
        System.out.println("4. Pikachu (Attacks: 1, Attack Power: 10, Defense Power: 4)");
        System.out.print("Select your Character (Enter the number of character): ");
        Character characterP1 = null;
        int characterNumP1 = Integer.valueOf(scanner.nextLine());

        switch (characterNumP1) {
            case 1:
                characterP1 = Charizard;
                break;
            case 2:
                characterP1 = Blaitoise;
                break;
            case 3:
                characterP1 = Venusaur;
                break;
            case 4:
                characterP1 = Pikachu;
                break;
            default:
                System.out.println("ERROR! ENTER A NUMBER FROM 1 TO 4!");
                System.exit(0);
                break;
        }

        Player playerP1 = new Player(playerNameP1, characterP1, 40);
        players[0] = playerP1;
        System.out.println("---------------------------------------------------------");
        System.out.println("Successfully created Player " + playerP1.name + " with Character " + characterP1.name + ".");
        System.out.println("---------------------------------------------------------");

        // Determine the specs of Player 2 + Check if the character choices are the same
        System.out.print("Enter the name of Player 2: ");
        String playerNameP2 = scanner.nextLine();

        System.out.println("@ Character list @");
        System.out.println("1. Charizard (Attacks: 2, Attack Power: 10, Defense Power: 0)");
        System.out.println("2. Blaitoise (Attacks: 2, Attack Power: 8, Defense Power: 1)");
        System.out.println("3. Venusaur (Attacks: 2, Attack Power: 5, Defense Power: 2)");
        System.out.println("4. Pikachu (Attacks: 1, Attack Power: 10, Defense Power: 4)");
        System.out.print("Select your Character (Enter the number of character): ");
        Character characterP2 = null;
        int characterNumP2 = Integer.valueOf(scanner.nextLine());

        if (characterNumP2 == characterNumP1) {
            System.out.println("Sorry, your character cannot be same as the previous choice.");
            System.exit(0);
        }

        switch (characterNumP2) {
            case 1:
                characterP2 = Charizard;
                break;
            case 2:
                characterP2 = Blaitoise;
                break;
            case 3:
                characterP2 = Venusaur;
                break;
            case 4:
                characterP2 = Pikachu;
                break;
            default:
                System.out.println("ERROR! ENTER A NUMBER FROM 1 TO 4!");
                System.exit(0);
                break;
        }

        Player playerP2 = new Player(playerNameP2, characterP2, 40);
        players[1] = playerP2;
        System.out.println("---------------------------------------------------------");
        System.out.println("Successfully created Player " + playerP2.name + " with Character " + characterP2.name + ".");
        System.out.println("---------------------------------------------------------");

        Player p1 = players[0];
        Player p2 = players[1];
        System.out.println("--------------------------------------------------------");
        System.out.println("Successfully created Player 1: " + p1.name + " and Player 2: " + p2.name + ".");
        System.out.println("--------------------------------------------------------");
        readManual();
        Level newLevel = new Level(level);
        currentLevel = newLevel;
        newLevel.startLevel();
    }

    public void checkScore() {
        Player p1 = players[0];
        Player p2 = players[1];
        System.out.println("Current Score - " + p1.name + ": " + p1.winnum + " AND " + p2.name + ": " + p2.winnum);

        if ((p1.winnum == 0 && p2.winnum == 2) || (p1.winnum == 2 && p2.winnum == 0)) {
            level = 3;
            increaseLevel();
        }
    }

    public void increaseLevel() {
        Player p1 = players[0];
        Player p2 = players[1];
        if (level == 3) {
            System.out.println("----------------------------------------------------");
            if (p1.winnum - p2.winnum == 2 || p2.winnum - p1.winnum == 2) {
                System.out.println("Winner is determined in only 2 levels!");
            }
            else {
                System.out.println("All the 3 levels are completed.");
            }
            Player winner = getWinner();
            System.out.println("The winner is " + winner.name + ". Congratulations! ^_^");
            System.out.println("----------------------------------------------------");
            restartGame();
        }
        else {
            level++;
            Level newLevel = new Level(level);
            players[0].hp = 40;
            players[1].hp = 40;
            currentLevel = newLevel;
            System.out.println("-------------------");
            System.out.println("Level increased!");
            System.out.println("-------------------");
            newLevel.startLevel();
        }
    }

    public Player getWinner() {
        Player p1 = players[0];
        Player p2 = players[1];

        if (p1.winnum > p2.winnum) {
            return p1;
        }
        return p2;
    }

    public void restartGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to restart the game? (true/false): ");
        boolean decision = scanner.nextBoolean();

        if (decision == true) {
            level = 1;
            startGame();
        }
        else {
            System.exit(0);
        }
    }

    public void readManual() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to view the gameplay manual? (true/false): ");
        boolean choice = scanner.nextBoolean();

        if (choice == true) {
            clearConsole();
            System.out.println("--------------------------------------------------------------------");
            System.out.println("Gameplay Manual:");
            System.out.println("Each player can choose an attack at the beginning.");
            System.out.println("There are two types of attacks: Hand Attack and Foot Attack.");
            System.out.println("After choosing the attack, the other player has to choose a defense.");
            System.out.println("There are two types of defenses: Hand Defense and Foot Defense.");
            System.out.println("If both players chose the same type, then the attack fails.");
            System.out.println("If the players chose different types, then the attack succeeds.");
            System.out.println("The attack takes out the HP by the amount of the difference,");
            System.out.println("between the Attack Power of P1 and the Defense Power of P2.");
            System.out.println("--------------------------------------------------------------------");
            promptEnterKey();
            clearConsole();
        }
        else {
            clearConsole();
        }
    }

    public void promptEnterKey() {
        System.out.print("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}