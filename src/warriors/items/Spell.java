package warriors.items;

import warriors.Content;
import warriors.heroes.AbstractHero;

public class Spell extends Content {
    private int attackBonus;

    public Spell(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public String doEvent(AbstractHero hero) {
        hero.setEquipment(this);
        hero.setBoostAttack(this.attackBonus);
        return "Le hero recoit "+ this.attackBonus + " points d'attaque";
    }
}
