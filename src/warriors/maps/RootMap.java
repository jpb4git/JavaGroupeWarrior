package warriors.maps;

import warriors.contracts.Map;

import java.util.HashMap;

public class RootMap implements Map {
    private String name;
    private int numberOfCase;
    private  HashMap <Integer , String> initialBoard;



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

    public HashMap<Integer, String> getInitialBoard() {
        return initialBoard;
    }

    public int getNumberOfCase() {
        return numberOfCase;
    }


    private void  init(){
        initialBoard.put(45, "Dragon");
        initialBoard.put(52, "Dragon");
        initialBoard.put(56, "Dragon");
        initialBoard.put(62, "Dragon");

        initialBoard.put(10, "Sorcier");
        initialBoard.put(20, "Sorcier");
        initialBoard.put(25, "Sorcier");
        initialBoard.put(32, "Sorcier");
        initialBoard.put(35, "Sorcier");
        initialBoard.put(36, "Sorcier");
        initialBoard.put(37, "Sorcier");
        initialBoard.put(40, "Sorcier");
        initialBoard.put(44, "Sorcier");
        initialBoard.put(47, "Sorcier");

        initialBoard.put(3, "Gobelin");
        initialBoard.put(6, "Gobelin");
        initialBoard.put(9, "Gobelin");
        initialBoard.put(12, "Gobelin");
        initialBoard.put(15, "Gobelin");
        initialBoard.put(18, "Gobelin");
        initialBoard.put(21, "Gobelin");
        initialBoard.put(24, "Gobelin");
        initialBoard.put(27, "Gobelin");
        initialBoard.put(30, "Gobelin");


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
