package warriors.front;

import java.util.ArrayList;
import java.util.List;

public class GameStateAPI {

    public Map map;
    public Hero hero;
    public gameState gamestate;


    public static class Map {
        public String name;
        public int size;
        public ArrayList<Case> initialBoard;

    }

    public static class Hero {
        public String name;
        public String image;
        public int life;
        public int attackLevel;
        public int maxLife;
        public int maxAttackLevel;
        public String type;

    }


    public static class gameState{
        public int dice;
        public Enum status;

    }

    public static class Case {
        public String name;
        public int life;
        public int power;
        public Enum type;
        public int position;
        public boolean isHeroHere;
    }
}
