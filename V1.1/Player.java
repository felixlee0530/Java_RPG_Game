
public class Player {

    public int hp;
    public Character character;
    public String name;
    public int winnum = 0;

    public Player(String name, Character character, int hp) {
        this.name = name;
        this.character = character;
        this.hp = hp;
    }

    public boolean removeHP(int remove) {
        hp = hp - remove;

        if (hp <= 0) {
            return true;
        }
        else {
            return false;
        }
    }
}