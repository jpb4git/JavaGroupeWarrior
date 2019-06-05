package warriors.heroes;

import warriors.Content;
import warriors.Offensive;
import warriors.contracts.Hero;

public abstract class AbstractHero implements Hero {
    private String name;
    private String image;
    private int life;
    private int attackLevel;
    private Offensive equipment;


    public AbstractHero(String name, String image, int life, int attackLevel) {
        this.name = name;
        this.image = image;
        this.life = life;
        this.attackLevel = attackLevel;
    }

    public Offensive getEquipment() {
        return equipment;
    }

    public void setEquipment(Offensive equipment) {
        this.equipment = equipment;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }
}
