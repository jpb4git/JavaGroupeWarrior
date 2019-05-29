package warriors.maps;

import warriors.contracts.Map;

public class RootMap implements Map {
    private String name;
    private int numberOfCase;

    public RootMap(String name, int numberOfCase) {
        this.name = name;
        this.numberOfCase = numberOfCase;
    }
    public String getName() {
        return name;
    }

    public int getNumberOfCase() {
        return numberOfCase;
    }

}
