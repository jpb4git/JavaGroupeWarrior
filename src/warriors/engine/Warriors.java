package warriors.engine;

import warriors.contracts.*;
import warriors.game.states.State;
import warriors.heroes.Swordman;
import warriors.heroes.Wizard;
import warriors.maps.RootMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Warriors implements WarriorsAPI {
    private ArrayList<Hero> heroes = new ArrayList<>();
    private ArrayList<Map> maps = new ArrayList<>();
    private State state;


    public Warriors() {
        this.heroes.add(new Wizard("Wizard1", "url",3, 8));
        this.heroes.add(new Swordman("Swordman1", "url",5, 10));

        this.maps.add(new RootMap("Map1", 64));

    }

    public GameState getState() {
        return state;
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
        this.state = new State(playerName, hero, map);
        return this.state;
    }

    @Override
    public GameState nextTurn(String gameID) {
        int currentCase = this.state.getCurrentCase();
        Random rand = new Random();

        int next = rand.nextInt(6)+1;
        int newCase = currentCase+next;
        this.state.setCurrentCase(newCase);


        if (newCase > this.getState().getMap().getNumberOfCase() ){
            state.setGameStatus(GameStatus.FINISHED);
            state.setLastLog("La partie est terminée.");
        }else{
            state.setLastLog("Le joueur est sur la case " + newCase);
        }
        return this.getState();

    }

}
