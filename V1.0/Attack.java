/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Attack {

    public int attacktype;
    public int defensetype;

    public Attack(int attacktype, int defensetype) {
        this.attacktype = attacktype;
        this.defensetype = defensetype;
    }

    public boolean performAttack() {
        if(attacktype == defensetype) {
            return false;
        } else {
            return true;
        }
    }

}
