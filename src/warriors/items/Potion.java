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
    public String doEvent(Hero hero) {
        AbstractHero player = (AbstractHero) hero;
        player.setLife(player.getLife() + this.healPts);
        return "Le hero recoit "+ this.healPts + " points de vie"+"\n"+"Il a maintenant "+player.getLife()+" points de vie";
    }

    public int getHealPts() {
        return this.healPts;
    }
}
