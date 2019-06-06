package warriors;

import warriors.heroes.AbstractHero;
import warriors.items.Blank;

/**
 * Tile scattered on the map, contains whether an item, a mob or a blank object
 */
public class Case {
    private Content content;

    public Case(Content content) {
        this.content = content;
    }

    /**
     * Function that manage the doEvent method and empty a tile if necessary depending on doEvent result.
     * @param hero (Hero) - Hero that item/mob has to be applied or fight
     * @return message (String) - Message returned by the item or mob
     */
    public String prepareEvent(AbstractHero hero) {
        String message = content.doEvent(hero);
        if (content.tileToClear == true){
            content = new Blank("Case vide");
            message += " \nLa case a ete videe";
        }
        return message;
    }

    /*****************************   GETTERs/SETTERs   *************************/
    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
