/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Player {

    public int hp;
    public Character character;
    public String name;
    public int winns = 0;

    public Player(String name, Character character, int hp) {
        this.name = name;
        this.character = character;
        this.hp = hp;
    }

    public boolean removeHP(int remove) {
        hp = hp-remove;
        if(hp <= 0) {
            return true;
        }
        return false;
    }

}