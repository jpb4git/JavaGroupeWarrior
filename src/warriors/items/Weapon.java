package warriors.items;

import warriors.Offensive;
import warriors.heroes.AbstractHero;
import warriors.heroes.Swordman;

public class Weapon extends Offensive {
    private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public String doEvent(AbstractHero hero) {
        if (hero instanceof Swordman) {
            hero.setEquipment(this);
            this.tileToClear = true;
            return "Le hero recoit " + this.attackBonus + " points d'attaque";
        } else {
            return "Le hero ne peut pas s'equiper de " + this.getName();
        }
    }

    public int getAttackBonus() {
        return attackBonus;
    }

}
