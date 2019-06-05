package warriors;

import warriors.heroes.AbstractHero;
import warriors.items.Blank;

public class Case {
    private Content content;

    public Case(Content content) {
        this.content = content;
    }

    public String prepareEvent(AbstractHero hero) {
        String message = content.doEvent(hero);
        if (content.tileToClear == true){
            content = new Blank("Case vide");
            message += " \nLa case a ete videe";
        }
        return message;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }
}
