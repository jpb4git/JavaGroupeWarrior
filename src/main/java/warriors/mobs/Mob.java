package warriors.mobs;

import warriors.Content;
import warriors.Offensive;
import warriors.heroes.AbstractHero;

/**
 * Main ennemi class available on tiles
 */
public class Mob extends Content {

    private int healthPts;
    private int attackPts;

    public Mob(String name, int healthPts, int attackPts) {
        super(name);
        this.healthPts = healthPts;
        this.attackPts = attackPts;
    }

    /**
     * Action to be performed when player reach a tile containing a mob
     * @param hero (Hero) - Hero that item has to be applied
     * @return (String) - Message about the equipment being applied or not.
     */
    @Override
    public String doEvent(AbstractHero hero) {
        String status = "Points de vie : " + this.healthPts + " - " + "Points d'attaque : " + this.attackPts + "\n";
        status += fight(hero);
        return status;
    }

    /**
     * @param hero (Hero) - Hero that has to fight against the mob
     * @return message (String) - Display the fight summary
     */
    private String fight(AbstractHero hero){
        String message = "Debut du combat.\n";
        int heroAttackPts = (hero.getEquipment() == null)? hero.getAttackLevel() : hero.getAttackLevel() + hero.getEquipment().getAttackBonus();
        this.healthPts -= heroAttackPts;

        message += "Le hero enleve " + heroAttackPts + " points de vie a l'ennemi. ";

        if(this.healthPts > 0){
            message += "Il lui reste " + this.healthPts + " points de vie.\n";
            message += "L'ennemi enleve "+ this.attackPts +" points de vie au hero.\n";
            int heroLife = hero.getLife()-this.attackPts;
            hero.setLife(heroLife);
        }else{
            this.tileToClear = true;
            message += "Il a ete eradique.\n";
        }

        message += " ";
        message += "Fin du combat.\n";
        if(hero.getLife() > 0){
            message += "Le hero va bien. Il lui reste " + hero.getLife() + " points de vie";
        }
        return message;
    }

    /*****************************   GETTERs/SETTERs   *************************/
    public int getHealthPts() {
        return healthPts;
    }

    public int getAttackPts() {
        return attackPts;
    }

}
