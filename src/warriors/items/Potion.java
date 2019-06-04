package warriors.items;

import warriors.Event;
import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

public class Potion extends Event {
    private int healPts;

    public Potion(String name, int healPts){
        super(name);
        this.healPts = healPts;
    }

    @Override
    public String doEvent(AbstractHero hero) {
        hero.setLife(hero.getLife() + this.healPts);
        return "Le hero recoit "+ this.healPts + " points de vie"+"\n"+"Il a maintenant "+hero.getLife()+" points de vie";
    }

    public int getHealPts() {
        return this.healPts;
    }
}
