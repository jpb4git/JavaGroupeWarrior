package warriors;

import warriors.heroes.AbstractHero;

/**
 * (ABSTRACT) - Intermediary class for offensive items. Extends Content, is extended by Spell or Weapon
 */
public abstract class Offensive extends Content {

    public Offensive(String name, String type) {
        super(name, type);
    }

    public abstract int getAttackBonus();
}
