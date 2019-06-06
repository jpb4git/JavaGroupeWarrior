package warriors.maps;

import warriors.Case;
import warriors.Content;
import warriors.contracts.Map;
import warriors.items.Blank;
import warriors.items.Potion;
import warriors.items.Spell;
import warriors.items.Weapon;
import warriors.mobs.Mob;

import java.util.*;


/**
 * Implement Map - Board containing a specific set of tile
 */
public class RootMap implements Map {
    private String name;
    private int numberOfCase;
    private ArrayList<Case> initialBoard;
    private ArrayList<Integer> scenario;

    public RootMap(String name, int numberOfCase, ArrayList<Integer> scenario) {
        this.name = name;
        this.numberOfCase = numberOfCase;
        this.initialBoard = new ArrayList<>();
        this.scenario = scenario;
        this.init();
    }


    /**
     * Set up all required tiles by type and shuffle them
     */
    private void init() {

        for (int i = 0; i < 14; i++) {
            initialBoard.add(new Case(new Blank("Case vide")));
        }
        for (int i = 0; i < 4; i++) {
            initialBoard.add(new Case(new Mob("Dragon", 15, 4)));
        }
        for (int i = 0; i < 10; i++) {
            initialBoard.add(new Case(new Mob("Warlock", 9, 2)));
        }

        for (int i = 0; i < 10; i++) {
            initialBoard.add(new Case(new Mob("Gobelin", 6, 1)));
        }
        for (int i = 0; i < 5; i++) {
            initialBoard.add(new Case(new Weapon("Arc", 1)));
        }
        for (int i = 0; i < 3; i++) {
            initialBoard.add(new Case(new Weapon("Massue", 3)));
        }
        for (int i = 0; i < 2; i++) {
            initialBoard.add(new Case(new Weapon("Epee", 5)));
        }
        for (int i = 0; i < 5; i++) {
            initialBoard.add(new Case(new Spell("Sort \"eclair\"", 2)));
        }
        for (int i = 0; i < 2; i++) {
            initialBoard.add(new Case(new Spell("Sort \"boule de feu\"", 7)));
        }
        for (int i = 0; i < 5; i++) {
            initialBoard.add(new Case(new Potion("Potion mineure", 1)));
        }
        for (int i = 0; i < 3; i++) {
            initialBoard.add(new Case(new Potion("Potion standard", 2)));
        }
        initialBoard.add(new Case(new Potion("Potion maxi", 5)));

        if (scenario == null) {
            Collections.shuffle(initialBoard, new Random(150));
       /* int i = 0;
        for (Case index : initialBoard) {
            System.out.println(i +" " +index.getContent().getName());
            i++;
        }*/
        }
    }

    /*****************************   GETTERs/SETTERs   *************************/

    public String getName() {
        return name;
    }

    public ArrayList<Case> getInitialBoard() {
        return initialBoard;
    }

    public int getNumberOfCase() {
        return numberOfCase;
    }
}
