package warriors.engine;

import warriors.heroes.Swordman;
import warriors.heroes.Wizard;
import warriors.contracts.GameState;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.maps.RootMap;

import java.util.ArrayList;
import java.util.List;

public class Warriors implements WarriorsAPI {
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<Map> maps = new ArrayList<>();

    public Warriors() {
        this.heroes.add(new Wizard("Wizard1", "url",3, 8));
        this.heroes.add(new Swordman("Swordman1", "url",5, 10));

        this.maps.add(new RootMap("Map1", 64));
    }

    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }

    @Override
    public List<Map> getMaps() {
        return this.maps;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        return null;
    }

    @Override
    public GameState nextTurn(String gameID) {
        return null;
    }
}
