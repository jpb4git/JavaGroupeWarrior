package warriors.items;

import warriors.Content;
import warriors.heroes.AbstractHero;

/**
 * Extands Content - Empty tile on board
 */
public class Blank extends Content {
    public Blank(String name) {
        super(name, "Blank");
    }

    /**
     * Action to be performed when player reach a tile containing this item
     * @param hero (Hero) - Hero that item has to be applied
     * @return (String) - Message saying that's an empty tile.
     */
    @Override
    public String doEvent(AbstractHero hero) {
        return "Il ne se passe rien";
    }
}
