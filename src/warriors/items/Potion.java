package warriors.items;

import warriors.Content;
import warriors.heroes.AbstractHero;
/**
 * Extands Content - Potion tile on board
 */
public class Potion extends Content {
    private int healPts;

    public Potion(String name, int healPts){
        super(name);
        this.healPts = healPts;
    }

    /**
     * Action to be performed when player reach a tile containing this item
     * @param hero (Hero) - Hero that item has to be applied
     * @return (String) - Message about the equipment being applied or not.
     */
    @Override
    public String doEvent(AbstractHero hero) {
        hero.setLife(hero.getLife() + this.healPts);
        this.tileToClear = true;
        return "Le hero recoit "+ this.healPts + " points de vie"+"\n"+"Il a maintenant "+hero.getLife()+" points de vie";
    }

    public int getHealPts() {
        return this.healPts;
    }

}
