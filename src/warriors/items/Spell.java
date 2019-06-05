package warriors.items;

import warriors.Offensive;
import warriors.heroes.AbstractHero;
import warriors.heroes.Wizard;

public class Spell extends Offensive {
    private int attackBonus;

    public Spell(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public String doEvent(AbstractHero hero) {
        if (hero instanceof Wizard) {
            hero.setEquipment(this);
            return "Le hero recoit " + this.attackBonus + " points d'attaque";
        } else {
            return "Le hero ne peut pas s'equiper de " + this.getName();
        }
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}
