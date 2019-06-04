package warriors.mobs;

import warriors.Content;
import warriors.heroes.AbstractHero;

public class Mob extends Content {

    private int healthPts;
    private int attackPts;

    public Mob(String name, int healthPts, int attackPts) {
        super(name);
        this.healthPts = healthPts;
        this.attackPts = attackPts;
    }

    @Override
    public String doEvent(AbstractHero hero) {
        String status = "Points de vie : " + this.healthPts + " - " + "Points d'attaque : " + this.attackPts + "\n";
        status += fight(hero);
        return status;
    }
    private String fight(AbstractHero hero){
        String message = "Debut du combat.\n";
        int heroAttackPts = hero.getAttackLevel() + hero.getBoostAttack();
        this.healthPts -= heroAttackPts;

        message += "Le hero enleve " + heroAttackPts + " points de vie a l'ennemi. ";

        if(this.healthPts > 0){
            message += "Il lui reste " + this.healthPts + "points de vie.\n";
            message += "L'ennemi enleve "+ this.attackPts +" points de vie au hero.\n";
            int heroLife = hero.getLife()-this.attackPts;
            hero.setLife(heroLife);
        }else{
            message += "Il a ete eradique.\n";
        }

        message += " ";
        message += "Fin du combat.\n";
        if(hero.getLife() > 0){
            message += "Le héro va bien. Il lui reste " + hero.getLife();
        }else{
            message += "Le héro est mort.";
        }
        return message;
    }

    public int getHealthPts() {
        return healthPts;
    }

    public int getAttackPts() {
        return attackPts;
    }

}
