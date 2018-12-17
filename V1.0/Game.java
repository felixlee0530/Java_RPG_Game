/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Scanner;

public class Game {

    int level = 1;
    public Level currentLevel;
    public int users;
    Player[] players;

    Character Charizard;
    Character Blaitoise;
    Character Venusaur;
    Character Pikachu;

    public Game() {
        Charizard = new Character("Charizard", 2, 10, 0);
        Blaitoise = new Character("Blaitoise", 2, 8, 1);
        Venusaur = new Character("Venusaur", 2, 5, 2);
        Pikachu = new Character("Pikachu", 1, 10, 4);

    }

    public void startGame() throws IOException {
        System.out.println("Hello, welcome to the RPG Adventure Game");

        Scanner scanner = new Scanner(System. in);
        int users = 2;
        players = new Player[users];
        this.users = users;

        System.out.println("Character list:");
        System.out.println("1. Charizard (Attacks: 2, Attack: 10, Defense: 0)");
        System.out.println("2. Blaitoise (Attacks: 2, Attack: 8, Defense: 1)");
        System.out.println("3. Venusaur (Attacks: 2, Attack: 5, Defense: 2)");
        System.out.println("4. Pikachu (Attacks: 1, Attack: 10, Defense: 4)");

        for(int i = 0; i < users ; i++) {
            System.out.println("Select the name of User: " + i + " : {Type it now}");
            String username = scanner.nextLine();
            System.out.println("Select the Character (Number)");
            Character character = null;
            int characterNumber = Integer.valueOf(scanner.nextLine());

            if(characterNumber == 1) {
                character = Charizard;
            } else if(characterNumber == 2) {
                character = Blaitoise;
            } else if (characterNumber == 3) {
                character = Venusaur;
            } else if (characterNumber == 4) {
                character = Pikachu;
            } else {
                System.out.println("Error! Enter a number between 1 and 4.");
            }

            Player player = new Player(username, character, 50);
            players[i] = player;
            System.out.println("You successfully created the User: " + player.name + " (" + character.name + ")");
        }
        System.out.println("You created the users successfully.");
        Level newLevel = new Level(level);
        currentLevel = newLevel;
        newLevel.startLevel();


    }

    public void upperLevel() throws IOException {
        if(level == 3) {
            System.out.println("The game is finished.");
            Player winner = getWinner();
            System.out.println("The winner is: " + winner.name);
            return;
        }
        level++;
        Level newLevel = new Level(level);
        players[0].hp = 50;
        players[1].hp = 50;
        currentLevel = newLevel;
        newLevel.startLevel();
        System.out.println("You are now in level " + newLevel + " of 3 levels.");
    }

    public Player getWinner() {
        Player p1 = players[0];
        Player p2 = players[1];

        if(p1.winns > p2.winns) {
            return p1;
        }
        return p2;

    }

}