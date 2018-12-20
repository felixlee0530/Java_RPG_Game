
import java.util.Scanner;

public class Level {

    int difficulty;
    Game game;
    public boolean death;


    public Level(int difficulty) {
        this.difficulty = difficulty;
        this.game = RPGGame.game;
    }

    public void startLevel() {
        System.out.println("-----------------------------------");
        System.out.println("You started LEVEL " + difficulty + "!");
        System.out.println("-----------------------------------");
        Scanner scanner = new Scanner(System.in);
        Player p1 = game.players[0];
        Player p2 = game.players[1];

        while (death == false) {
            // This is the turn of Player 1. (p1)
            System.out.println("-----------------------------------");
            System.out.println(p1.name + " IS ATTACKING NOW! ");
            System.out.println("-----------------------------------");


            for (int i = 1; i <= p1.character.attacksPerRound; i++) {
                System.out.println("-------------------------------------------------------");
                System.out.println("1: Hand Attack");
                System.out.println("2: Foot Attack");
                System.out.print(p1.name + ", it is " + i + "/" + p1.character.attacksPerRound + " in this round. Select your Attack: ");
                int attack = Integer.valueOf(scanner.nextLine());
                if (attack >= 3 || attack <= 0) {
                    System.out.println("Error! You can only choose between 1: Hand Attack and 2: Foot Attack");
                    System.exit(0);
                }

                clearConsole();

                System.out.println(p1.name + " selected his/her attack!");
                System.out.println("-------------------------------------------------------");
                System.out.println("1: Hand Defense");
                System.out.println("2: Foot Defense");
                System.out.print(p2.name + ", now it is your turn. Select your Defense: ");
                int defense = Integer.valueOf(scanner.nextLine());
                if (defense >= 3 || defense <= 0) {
                    System.out.println("Error! You can only choose between 1: Hand Defense and 2: Foot Defense");
                    System.exit(0);
                }

                clearConsole();

                Attack attacking = new Attack(attack, defense);
                boolean success = attacking.performAttack();

                if (success == true) {
                    int remove = p1.character.attackPower - p2.character.defensePower;
                    boolean death = p2.removeHP(remove);
                    if (death == true) {
                        playerDeath(p2, p1);
                        return;
                    }
                    System.out.println(p1.name + " successfully attacked " + p2.name + " and removed " + remove + " HP.");
                }
                else {
                    System.out.println(p1.name + " failed to attack " + p2.name + ". He/She successfully defensed your attack.");
                }
            }

            // This is the turn of Player 2. (p2)
            System.out.println("-----------------------------------");
            System.out.println(p2.name + " IS ATTACKING NOW! ");
            System.out.println("-----------------------------------");


            for (int i = 1; i <= p2.character.attacksPerRound; i++) {
                System.out.println("-------------------------------------------------------");
                System.out.println("1: Hand Attack");
                System.out.println("2: Foot Attack");
                System.out.print(p2.name + ", it is " + i + "/" + p2.character.attacksPerRound + " in this round. Select your Attack: ");
                int attack = Integer.valueOf(scanner.nextLine());
                if (attack >= 3 || attack <= 0) {
                    System.out.println("Error! You can only choose between 1: Hand Attack and 2: Foot Attack");
                    System.exit(0);
                }

                clearConsole();

                System.out.println(p2.name + " selected his/her attack!");
                System.out.println("-------------------------------------------------------");
                System.out.println("1: Hand Defense");
                System.out.println("2: Foot Defense");
                System.out.print(p1.name + ", now it is your turn. Select your Defense: ");
                int defense = Integer.valueOf(scanner.nextLine());
                if (defense >= 3 || defense <= 0) {
                    System.out.println("Error! You can only choose between 1: Hand Defense and 2: Foot Defense");
                    System.exit(0);
                }

                clearConsole();

                Attack attacking = new Attack(attack, defense);
                boolean success = attacking.performAttack();

                if (success == true) {
                    int remove = p2.character.attackPower - p1.character.defensePower;
                    boolean death = p1.removeHP(remove);
                    if (death == true) {
                        playerDeath(p1, p2);
                        return;
                    }
                    System.out.println(p2.name + " successfully attacked " + p1.name + " and removed " + remove + " HP.");
                }
                else {
                    System.out.println(p2.name + " failed to attack " + p1.name + ". He/She successfully defensed your attack.");
                }
            }

            System.out.println("-------------------------------------------------------");
            System.out.println("HP REMAIN FOR PLAYERS " + p1.name + " AND " + p2.name + ":");
            System.out.println("Player " + p1.name + ": " + p1.hp + "/40");
            System.out.println("Player " + p2.name + ": " + p2.hp + "/40");

            if (p1.hp <= 10) {
                System.out.println("WARNING! " + p1.name + ", you only have " + p1.hp + " HP remain!!");
            }
            if (p2.hp <= 10) {
                System.out.println("WARNING! " + p2.name + ", you only have " + p2.hp + " HP remain!!");
            }
            if (p1.hp > 10 && p2.hp > 10) {
                System.out.println("Both players have enough HP left!");
            }
            System.out.println("-------------------------------------------------------");
        }
    }

    public void playerDeath(Player death, Player winner) {
        System.out.println("Oh no! Player " + death.name + " died.");
        System.out.println("HP remain of " + winner.name + ": " + winner.hp + "/40");
        winner.winnum++;
        game.checkScore();
        game.increaseLevel();
        this.death = true;
    }

    public void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }
}