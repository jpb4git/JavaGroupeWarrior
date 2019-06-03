package warriors.items;

import warriors.Event;
import warriors.contracts.Hero;

public class Weapon extends Event {

    @Override
    public String doEvent(Hero hero) {
        return null;
    }

    public Weapon(String name) {
        super(name);
    }
    /*public Weapon(int attackBonus){
        super(attackBonus);
    }*/
}
