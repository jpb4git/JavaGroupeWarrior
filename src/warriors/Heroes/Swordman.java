package warriors.Heroes;

public class Swordman extends AbstractHero {
    public Swordman(String name, String img, int life, int attack) {
        super(name, img, life, attack);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getImage() {
        return null;
    }

    @Override
    public int getLife() {
        return 0;
    }

    @Override
    public int getAttackLevel() {
        return 0;
    }
}
