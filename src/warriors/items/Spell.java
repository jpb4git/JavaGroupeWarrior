package warriors.items;

import warriors.Event;
import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

public class Spell extends Event {
    private int attackBonus;

    public Spell(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public String doEvent(AbstractHero hero) {
        hero.setAttackLevel(hero.getAttackLevel() + this.attackBonus);
        return "Le hero recoit "+ this.attackBonus + " points d'attaque"+"\n"+"Il a maintenant "+hero.getAttackLevel()+" points d'attaque";
    }

}
