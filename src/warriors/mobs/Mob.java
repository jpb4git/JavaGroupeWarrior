package warriors.mobs;

import warriors.Case;
import warriors.heroes.AbstractHero;

public class Mob extends Case {

    private int healthPts;
    private int attackPts;

    public Mob(String name, int healthPts, int attackPts) {
        super(name);
        this.healthPts = healthPts;
        this.attackPts = attackPts;
    }

    @Override
    public String doEvent(AbstractHero hero) {
        return "Points de vie = " + this.healthPts + "\n" + "Points d'attaque : " + this.attackPts;
    }

    public int getHealthPts() {
        return healthPts;
    }

    public int getAttackPts() {
        return attackPts;
    }

}
