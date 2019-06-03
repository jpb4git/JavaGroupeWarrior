package warriors.mobs;

public class mob {

    private int healthPts;
    private int attackPts;

    public mob(int healthPts, int attackPts ){
        this.healthPts = healthPts;
        this.attackPts = attackPts;
    }

    public int getHealthPts() {
        return healthPts;
    }

    public void setHealthPts(int healthPts) {
        this.healthPts = healthPts;
    }

    public int getAttackPts() {
        return attackPts;
    }

    public void setAttackPts(int attackPts) {
        this.attackPts = attackPts;
    }


}
