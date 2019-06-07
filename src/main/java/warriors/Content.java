package warriors;

import warriors.contracts.Hero;
import warriors.heroes.AbstractHero;

/**
 * (ABSTRACT) Main item/mob class.
 */
public abstract class Content {
    private String name;
    private String type;

    protected boolean tileToClear;

    public Content(String name, String type) {
        this.name = name;
        this.type = type;
        this.tileToClear = false;
    }

    /*****************************   GETTERs/SETTERs   *************************/
    public String getName() {
        return name;
    }

    public abstract String doEvent(AbstractHero hero);
}
