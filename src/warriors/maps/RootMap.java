package warriors.maps;

import warriors.Event;
import warriors.contracts.Map;
import warriors.items.Potion;
import warriors.items.Spell;
import warriors.items.Weapon;
import warriors.mobs.Mob;

import java.util.HashMap;

public class RootMap implements Map {
    private String name;
    private int numberOfCase;
    private  HashMap <Integer , Event> initialBoard;



    public RootMap(String name, int numberOfCase) {
        this.name = name;
        this.numberOfCase = numberOfCase;
        this.initialBoard = new HashMap<>();
        this.init();
    }

    public String getName()
    {
        return name;
    }

    public HashMap<Integer, Event> getInitialBoard() {

        return initialBoard;
    }

    public int getNumberOfCase() {
        return numberOfCase;
    }


    private void  init(){

        for(int i : new int[]{45, 52, 56, 62 }) {
            initialBoard.put(i, new Mob("Dragon",15,4));

        }

        for(int i : new int[]{10,20, 25, 32, 35, 36, 37, 40 , 44, 47}) {
            initialBoard.put(i, new Mob("Warlock", 9, 2));
        }


        for (int i=3; i<=30; i+=3) {
            initialBoard.put(i, new Mob("Gobelin",6,1));
        }

        initialBoard.put(2, new Weapon("Arc",1));
        initialBoard.put(11, new Weapon("Arc",1));
        initialBoard.put(14, new Weapon("Arc",1));
        initialBoard.put(19, new Weapon("Arc",1));
        initialBoard.put(26, new Weapon("Arc",1));

        initialBoard.put(5, new Weapon("Massue",3));
        initialBoard.put(22, new Weapon("Massue",3));
        initialBoard.put(38, new Weapon("Massue",3));

        initialBoard.put(42, new Weapon("Epee",5));
        initialBoard.put(53, new Weapon("Epee",5));

        initialBoard.put(1, new Spell("Sort \"eclair\"",2));
        initialBoard.put(4, new Spell("Sort \"eclair\"",2));
        initialBoard.put(8, new Spell("Sort \"eclair\"",2));
        initialBoard.put(17, new Spell("Sort \"eclair\"",2));
        initialBoard.put(23, new Spell("Sort \"eclair\"",2));

        initialBoard.put(48, new Spell("Sort \"boule de feu\"",7));
        initialBoard.put(49, new Spell("Sort \"boule de feu\"",7));

        initialBoard.put(7, new Potion("Potion mineure",1));
        initialBoard.put(13, new Potion("Potion mineure",1));
        initialBoard.put(28, new Potion("Potion mineure",1));
        initialBoard.put(29, new Potion("Potion mineure",1));
        initialBoard.put(33, new Potion("Potion mineure",1));

        initialBoard.put(31, new Potion("Potion standard",2));
        initialBoard.put(39, new Potion("Potion standard",2));
        initialBoard.put(43, new Potion("Potion standard",2));

        initialBoard.put(41, new Potion("Potion maxi",5));

    }
}
