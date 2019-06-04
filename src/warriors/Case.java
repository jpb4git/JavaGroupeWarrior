package warriors;

import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

public abstract class Case {
private String name;

    public Case(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String doEvent(AbstractHero hero);
}
