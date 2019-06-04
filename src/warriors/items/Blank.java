package warriors.items;

import warriors.Content;
import warriors.heroes.AbstractHero;

public class Blank extends Content {
    public Blank(String name) {
        super(name);
    }

    @Override
    public String doEvent(AbstractHero hero) {
        return "Il ne se passe rien";
    }
}
