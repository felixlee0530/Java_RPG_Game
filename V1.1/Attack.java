
public class Attack {

    public int attackType;
    public int defenseType;

    public Attack(int attackType, int defenseType) {
        this.attackType = attackType;
        this.defenseType = defenseType;
    }

    public boolean performAttack() {
        if (attackType == defenseType) {
            return false;
        }
        else {
            return true;
        }
    }
}