package warriors.items;

import warriors.Case;
import warriors.heroes.AbstractHero;

public class Blank extends Case{
    public Blank(String name) {
        super(name);
    }

    @Override
    public String doEvent(AbstractHero hero) {
        return "Il ne se passe rien";
    }
}
