package warriors.items;

import warriors.Offensive;
import warriors.heroes.AbstractHero;
import warriors.heroes.Wizard;

/**
 * Extands Content - Spell tile on board, can only be equiped by wizards
 */
public class Spell extends Offensive {
    private int attackBonus;

    public Spell(String name, int attackBonus) {
        super(name, "Spell");
        this.attackBonus = attackBonus;
    }


    /**
     * Action to be performed when player reach a tile containing this item
     * @param hero (Hero) - Hero that item has to be applied
     * @return (String) - Message about the equipment being applied or not.
     */
    public String doEvent(AbstractHero hero) {
        if (hero instanceof Wizard) {
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
