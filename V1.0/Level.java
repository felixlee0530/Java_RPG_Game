/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Scanner;

public class Level {

    int difficulty;
    Game game;
    public boolean death;
    public Player pdeath;


    public Level(int difficulty) {
        this.difficulty = difficulty;
        this.game = RPGGame.game;
    }

    public void startLevel() throws IOException {
        System.out.println("You start the " + difficulty + " Round.");
        Scanner scanner = new Scanner(System. in);
        //TODO FIRST USER
        Player p1 = game.players[0];
        Player p2 = game.players[1];
        while(death == false) {

            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println(p1.name + " IS ATTACKING NOW! ");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");


            for(int i = 1; i < p1.character.attacksPerRound+1; i++) {
                System.out.println(p1.name + ": It is " + i + " in this round. (Please hide your decision)");
                System.out.println("Select your Attack:");
                System.out.println("1: Hand attack");
                System.out.println("2: Foot Attack");
                int attack = Integer.valueOf(scanner.nextLine());
                if (attack >= 3) {
                    System.out.println("Error! You can only choose between 1: Hand attack and 2: Foot attack");
                }
                clearConsole();
                System.out.println(p1.name + "s attack was selected");
                System.out.println(p2.name + ": It is your turn. Please select a defense!");
                System.out.println("Select your Defense:");
                System.out.println("1: Hand Defense");
                System.out.println("2: Foot Defense");
                int defense = Integer.valueOf(scanner.nextLine());
                if (defense >= 3) {
                    System.out.println("Error! You can only choose between 1: Hand defense and 2: Foot defense");
                }
                clearConsole();
                Attack attacking = new Attack(attack, defense);
                boolean success = attacking.performAttack();
                if(success == true) {
                    int remove = p1.character.attackPower - p2.character.defensePower;
                    boolean death = p2.removeHP(remove);
                    if(death == true) {
                        playerDeath(p2, p1);
                        return;
                    }
                    System.out.println("You successfully attacked the Player and removed " + remove + " health.");
                } else {
                    System.out.println("You failed by attacking the Player. He successfully defensed your attack.");
                }
            }
            //clearConsole();
            //Player 2 turn
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            System.out.println(p2.name + " IS ATTACKING NOW!");
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - -");
            for(int i = 1; i < p2.character.attacksPerRound+1; i++) {
                System.out.println(p2.name + ": It is " + i + " attack in this round. (Please hide your decision)");
                System.out.println("Select your Attack:");
                System.out.println("1: Hand attack");
                System.out.println("2: Foot Attack");
                int attack = Integer.valueOf(scanner.nextLine());
                if (attack >= 3) {
                    System.out.println("Error! You can only choose between 1: Hand attack and 2: Foot attack");
                }
                clearConsole();
                System.out.println(p2.name + "s attack was selected");
                System.out.println(p1.name + ": It is your turn. Please select a defense!");
                System.out.println("Select your Defense:");
                System.out.println("1: Hand Defense");
                System.out.println("2: Foot Defense");
                int defense = Integer.valueOf(scanner.nextLine());
                if (defense >= 3) {
                    System.out.println("Error! You can only choose between 1: Hand defense and 2: Foot defense");
                }
                clearConsole();
                Attack attacking = new Attack(attack, defense);
                boolean success = attacking.performAttack();
                if(success == true) {
                    int remove = p2.character.attackPower - p1.character.defensePower;
                    boolean death = p1.removeHP(remove);
                    if(death == true) {
                        playerDeath(p1, p2);
                        return;
                    }


                    System.out.println("You successfully attacked the Player and removed " + remove + " health.");
                } else {
                    System.out.println("You failed by attacking the Player. He successfully defensed your attack.");
                }
            }
            // clearConsole();
            System.out.println("HP Remain: Player: " + p1.name + ": " + p1.hp);
            System.out.println("HP Remain: Player: " + p2.name + ": " + p2.hp);
        }

    }



    public void playerDeath(Player death, Player winner) throws IOException {
        System.out.println("Player " + death.name + " died.");
        winner.winns++;
        game.upperLevel();
        this.death = true;
    }

    void startLevel(int level) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void clearConsole() {
        for(int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

}