package warriors;

import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

/**
 * (ABSTRACT) Main item/mob class.
 */
public abstract class Content {
    private String name;

    protected boolean tileToClear;

    public Content(String name) {
        this.name = name;
        this.tileToClear = false;
    }

    /*****************************   GETTERs/SETTERs   *************************/
    public String getName() {
        return name;
    }

    public abstract String doEvent(AbstractHero hero);
}
