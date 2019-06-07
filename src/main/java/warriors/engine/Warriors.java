package warriors.engine;

import warriors.contracts.*;
import warriors.game.states.State;
import warriors.heroes.AbstractHero;
import warriors.heroes.Swordman;
import warriors.heroes.Wizard;
import warriors.maps.RootMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Class that contains main engine methods.
 */
public class Warriors implements WarriorsAPI {
    private ArrayList<Hero> heroes = new ArrayList<>();
    private List<RootMap> maps = new ArrayList<>();
    private State state;
    private ArrayList<Integer> scenario;
    private int nbTurn;


    public Warriors(ArrayList<Integer> scenario,RootMap jsonMap) {
        this.heroes.add(new Wizard("Wizard1", "url", 3, 8));
        this.heroes.add(new Swordman("Swordman1", "url", 5, 5));
        this.maps.add(new RootMap("Map1", 64, scenario));
        if (jsonMap != null){
            this.maps.add(jsonMap);
        }
        this.scenario = scenario;
        this.nbTurn = 0;
    }



    /**
     * Reset heroes an maps when restarting a game
     */
    private void initHeroes() {
        this.heroes.set(0, new Wizard("Wizard1", "url", 3, 8));
        this.heroes.set(1, new Swordman("Swordman1", "url", 5, 5));
        this.maps.set(0, new RootMap("Map1", 64, scenario));
        this.nbTurn = 0;
    }


    /**
     * Create a new game
     *
     * @param playerName (String) - Name choosen by the player
     * @param hero       (Hero) - Hero object selected by the player
     * @param map        (Map) - Board choosen by the player
     * @return state (State) - State of a game containing all informations about a game at a given turn
     */
    @Override
    public GameState createGame(String playerName, Hero hero, Map map) {
        this.state = new State(playerName, hero, (RootMap) map);
        return this.state;
    }

    /**
     * @param gameID (String) - Unique ID of a game
     * @return state (State) - updated state after a turn
     */
    @Override
    public GameState nextTurn(String gameID) {
        String message;
        int currentCase = this.state.getCurrentCase();
        Random rand = new Random();
        int next;
        if (scenario == null || nbTurn >= scenario.size()) {
            next = rand.nextInt(6) + 1;
        } else {
            next = this.scenario.get(this.nbTurn);
            this.nbTurn++;
        }

        message = "Lancoiemment du cube ! \n ";
        int newCase = currentCase + next;
        if( newCase> this.state.getMap().getNumberOfCase()-1){
            newCase = this.state.getMap().getNumberOfCase()-1;
            message += "Le joueur a fait " + next + ".\nLe joueur est arriv sur la derniere case.\n";
        }else{
            message += "Le joueur a fait " + next + ".\nIl excerce un deplacisme sur la case " + (newCase+1) + "\n";
        }
        this.state.setCurrentCase(newCase);

        try {

            String eventName = this.state.getMap()
                    .getInitialBoard()
                    .get(newCase).getContent().getName();

            Hero hero = state.getHero();
            String eventAction = this.state.getMap()
                    .getInitialBoard()
                    .get(newCase).prepareEvent((AbstractHero) hero);

            message += eventName + "\n";
            message += eventAction + "\n";

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        if (this.state.getHero().getLife() <= 0) {
            state.setGameStatus(GameStatus.FINISHED);
            message += "Le hero est mort ... GAME OVER !!";
            this.initHeroes();
        } else if (newCase >= this.state.getMap().getNumberOfCase()-1) {
            state.setGameStatus(GameStatus.FINISHED);
            message +="La partie est terminee.";
            this.initHeroes();
        }
        state.setLastLog(message);

        return this.state;
    }


    /*****************************   GETTERs/SETTERs   *************************/
    @Override
    public List<Hero> getHeroes() {
        return this.heroes;
    }

    @Override
    public List<? extends Map> getMaps() {
        return this.maps;
    }

    public void setMaps(List<RootMap> maps) {
        this.maps = maps;
    }
}
