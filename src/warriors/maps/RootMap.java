package warriors.maps;

import warriors.Event;
import warriors.contracts.Map;
import warriors.items.Potion;
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

       /* initialBoard.put(2, "Arc");
        initialBoard.put(11, "Arc");
        initialBoard.put(14, "Arc");
        initialBoard.put(19, "Arc");
        initialBoard.put(26, "Arc");

        initialBoard.put(5, "Massue");
        initialBoard.put(22, "Massue");
        initialBoard.put(38, "Massue");

        initialBoard.put(42, "Epée");
        initialBoard.put(53, "Epée");

        initialBoard.put(1, "Sort \"éclair\"");
        initialBoard.put(4, "Sort \"éclair\"");
        initialBoard.put(8, "Sort \"éclair\"");
        initialBoard.put(17, "Sort \"éclair\"");
        initialBoard.put(23, "Sort \"éclair\"");

        initialBoard.put(48, "Sort \"boule de feu\"");
        initialBoard.put(49, "Sort \"boule de feu\"");*/

        initialBoard.put(7, new Potion("Potion mineure",1));
        initialBoard.put(13, new Potion("Potion mineure",1));
        initialBoard.put(28, new Potion("Potion mineure",1));
        initialBoard.put(29, new Potion("Potion mineure",1));
        initialBoard.put(33, new Potion("Potion mineure",1));

        initialBoard.put(31, new Potion("Potion standard",2));
        initialBoard.put(39, new Potion("Potion standard",2));
        initialBoard.put(43, new Potion("Potion standard",2));

        initialBoard.put(41, new Potion("Potion maxi",5));

        /*initialBoard.put(16, "Vide");
        initialBoard.put(34, "Vide");
        initialBoard.put(46, "Vide");
        initialBoard.put(50, "Vide");
        initialBoard.put(51, "Vide");
        initialBoard.put(54, "Vide");
        initialBoard.put(55, "Vide");
        initialBoard.put(57, "Vide");
        initialBoard.put(58, "Vide");
        initialBoard.put(59, "Vide");
        initialBoard.put(60, "Vide");
        initialBoard.put(61, "Vide");
        initialBoard.put(63, "Vide");
        initialBoard.put(64, "Vide");*/


    }
}
