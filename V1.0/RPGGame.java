/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;

public class RPGGame {

    public static Game game;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        game = new Game();
        game.startGame();
    }

}