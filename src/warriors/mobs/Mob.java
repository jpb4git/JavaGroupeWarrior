package warriors.mobs;

import warriors.Event;
import warriors.contracts.Hero;

public class Mob extends Event {

    private int healthPts;
    private int attackPts;

    public Mob(String name, int healthPts, int attackPts) {
        super(name);
        this.healthPts = healthPts;
        this.attackPts = attackPts;
    }

    @Override
    public String doEvent(Hero hero) {
        return "Points de vie = " + this.healthPts + "\n" + "Points d'attaque : " + this.attackPts;
    }

    public int getHealthPts() {
        return healthPts;
    }

    public int getAttackPts() {
        return attackPts;
    }

}
