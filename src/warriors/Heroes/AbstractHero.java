package warriors.Heroes;

import warriors.contracts.Hero;

public abstract class AbstractHero implements Hero {
    private String name;
    private String img;
    private int life;
    private int attack;


    public AbstractHero(String name, String img, int life, int attack) {
        this.name = name;
        this.img = img;
        this.life = life;
        this.attack = attack;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

}
