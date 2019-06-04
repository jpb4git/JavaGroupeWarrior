package warriors;

import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

public abstract class Event {
private String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract String doEvent(AbstractHero hero);
}
