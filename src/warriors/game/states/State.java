package warriors.game.states;

import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;

public class State implements GameState {
    private String playerName;
    private Hero hero;
    private Map map;
    private final String gameId;
    private GameStatus gameStatus;
    private String lastLog;
    private int currentCase;

    public State(String playerName, Hero hero, Map map) {
        this.playerName = playerName;
        this.hero = hero;
        this.map = map;
        this.gameId = "#" + ((int) (Math.random() *999 - 1));
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.lastLog = "Début de la partie.";
        this.currentCase = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    @Override
    public String getGameId() {
        return gameId;
    }

    @Override
    public GameStatus getGameStatus() {
        return this.gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public Hero getHero() {
        return hero;
    }

    @Override
    public Map getMap() {
        return map;
    }

    @Override
    public String getLastLog() {
        return this.lastLog;
    }
    public void setLastLog(String lastLog){
        this.lastLog = lastLog;
    }

    @Override
    public int getCurrentCase() {
        return this.currentCase;
    }

    public void setCurrentCase(int currentCase) {
        this.currentCase = currentCase;
    }
}
