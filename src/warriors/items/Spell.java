package warriors.items;

import warriors.Event;
import warriors.contracts.Hero;

public class Spell extends Event {
    public Spell(String name) {
        super(name);
    }

    @Override
    public String doEvent(Hero hero) {
        return null;
    }
    /*public Spell(int attackBonus){
        super(attackBonus);
    }*/
}
