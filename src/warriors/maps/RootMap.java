package warriors.maps;

import warriors.contracts.Map;
import warriors.mobs.Dragon;
import warriors.mobs.Gobelin;
import warriors.mobs.Warlock;

import java.util.HashMap;

public class RootMap implements Map {
    private String name;
    private int numberOfCase;
    private  HashMap <Integer , Object> initialBoard;



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

    public HashMap<Integer, Object> getInitialBoard() {
        return initialBoard;
    }

    public int getNumberOfCase() {
        return numberOfCase;
    }


    private void  init(){
        initialBoard.put(45, new Dragon());
        initialBoard.put(52, new Dragon());
        initialBoard.put(56, new Dragon());
        initialBoard.put(62, new Dragon());

        initialBoard.put(10, new Warlock());
        initialBoard.put(20, new Warlock());
        initialBoard.put(25, new Warlock());
        initialBoard.put(32, new Warlock());
        initialBoard.put(35, new Warlock());
        initialBoard.put(36, new Warlock());
        initialBoard.put(37, new Warlock());
        initialBoard.put(40, new Warlock());
        initialBoard.put(44, new Warlock());
        initialBoard.put(47, new Warlock());

        initialBoard.put(3, new Gobelin());
        initialBoard.put(6, new Gobelin());
        initialBoard.put(9, new Gobelin());
        initialBoard.put(12, new Gobelin());
        initialBoard.put(15, new Gobelin());
        initialBoard.put(18, new Gobelin());
        initialBoard.put(21, new Gobelin());
        initialBoard.put(24, new Gobelin());
        initialBoard.put(27, new Gobelin());
        initialBoard.put(30, new Gobelin());


        initialBoard.put(2, "Arc");
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
        initialBoard.put(49, "Sort \"boule de feu\"");

        initialBoard.put(7, "Potion mineure");
        initialBoard.put(13, "Potion mineure");
        initialBoard.put(28, "Potion mineure");
        initialBoard.put(29, "Potion mineure");
        initialBoard.put(33, "Potion mineure");

        initialBoard.put(31, "Potion standard");
        initialBoard.put(39, "Potion standard");
        initialBoard.put(43, "Potion standard");

        initialBoard.put(41, "Potion maxi");

        initialBoard.put(16, "Vide");
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
        initialBoard.put(64, "Vide");


    }
}
