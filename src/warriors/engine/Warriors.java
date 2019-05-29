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
    private List<RootMap> maps = new ArrayList<>();
    private State state;


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
    public List<? extends Map> getMaps() {
        return this.maps;
    }

    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        this.state = new State(playerName, hero, (RootMap) map);
        return this.state;
    }

    @Override
    public GameState nextTurn(String gameID) {
        int currentCase = this.state.getCurrentCase();
        Random rand = new Random();

        int next = rand.nextInt(6)+1;
        int newCase = currentCase+next;
        this.state.setCurrentCase(newCase);


        if (newCase > this.state.getMap().getNumberOfCase() ){
            state.setGameStatus(GameStatus.FINISHED);
            state.setLastLog("La partie est terminée.");
        }else{

            state.setLastLog("Lancé du dé ! \nLe joueur a fait "+ next +".\nIl excerce un déplacisme sur la case " + newCase + "\n" + this.state.getMap().getInitialBoard().get(newCase).getClass().getSimpleName());


        }
        return this.state;
    }

}
