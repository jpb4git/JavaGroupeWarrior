package warriors;

import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

public abstract class Content {
private String name;

    public Content(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String doEvent(AbstractHero hero);
    //public abstract int getAttackLevel();
}
