package warriors.items;

import warriors.Case;
import warriors.heroes.AbstractHero;

public class Weapon extends Case {
private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name);
        this.attackBonus = attackBonus;
    }

    public String doEvent(AbstractHero hero) {
        hero.setAttackLevel(hero.getAttackLevel() + this.attackBonus);
        return "Le hero recoit "+ this.attackBonus + " points d'attaque"+"\n"+"Il a maintenant "+hero.getAttackLevel()+" points d'attaque";
    }

}
