package warriors;

import warriors.heroes.AbstractHero;

public abstract class Offensive extends Content {

    public Offensive(String name) {
        super(name);
    }
    public abstract int getAttackBonus();
}
