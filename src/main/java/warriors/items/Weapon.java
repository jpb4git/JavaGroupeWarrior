package warriors.items;

import warriors.Offensive;
import warriors.heroes.AbstractHero;
import warriors.heroes.Swordman;

/**
 * Extands Content - Weapon tile on board, can only be equiped by swordmen
 */
public class Weapon extends Offensive {
    private int attackBonus;

    public Weapon(String name, int attackBonus) {
        super(name, "Weapon");
        this.attackBonus = attackBonus;
    }

    /**
     * Action to be performed when player reach a tile containing this item
     * @param hero (Hero) - Hero that item has to be applied
     * @return (String) - Message about the equipment being applied or not.
     */
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
