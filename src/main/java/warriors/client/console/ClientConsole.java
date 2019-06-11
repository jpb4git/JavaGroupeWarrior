package warriors.client.console;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.*;

import warriors.Content;
import warriors.MyContentDeserializer;
import warriors.MyContentSerializer;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Warriors;
import warriors.maps.RootMap;



public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_QUITTER = "2";
    private static Map jsonMap = null;

    public static void main(String[] args) {



        ArrayList<Integer> scenario = null;

        if(args.length > 0){
            if(args[0].equals("Debug")) {
                scenario = csvToArraylist(args[1]);
            }else if(args[0].equals("Json")){
                System.out.println("ok" + args[1]);
                jsonMap = deserialyzed(args[1]);
                System.out.println(jsonMap);
            }
        }
        WarriorsAPI warriors = new Warriors(scenario,(RootMap) jsonMap);

        Scanner sc = new Scanner(System.in);
        String menuChoice = "";
        do {
            menuChoice = displayMenu(sc);
            if (menuChoice.equals(MENU_COMMENCER_PARTIE)) {
                startGame(warriors, sc);
            }
        } while (!menuChoice.equals(MENU_QUITTER));
        sc.close();
        System.out.println("A bientot");
    }

    private static void startGame(WarriorsAPI warriors, Scanner sc) {


        System.out.println();
        System.out.println("Entrez votre nom:");
        String playerName = sc.nextLine();

        System.out.println("Choisissez votre hero:");
        for (int i = 0; i < warriors.getHeroes().size(); i++) {
            Hero heroe = warriors.getHeroes().get(i);
            System.out.println(i + 1 + " - " + heroe.getName());
            System.out.println("    Force d'attaque : " + heroe.getAttackLevel());
            System.out.println("    Niveau de vie : " + heroe.getLife());
        }
        Hero chosenHeroe = warriors.getHeroes().get(Integer.parseInt(sc.nextLine()) - 1);

        System.out.println("Choisissez votre map:");
        for (int i = 0; i < warriors.getMaps().size(); i++) {
            Map map = warriors.getMaps().get(i);
            System.out.println(i + 1 + " - " + map.getName());
        }
        Map choosenMap = warriors.getMaps().get(Integer.parseInt(sc.nextLine()) - 1);

        GameState gameState = warriors.createGame(playerName, chosenHeroe, choosenMap);
        String gameId = gameState.getGameId();


        serialyze((RootMap) gameState.getMap());


        while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(gameState.getLastLog());
            System.out.println("\nAppuyer sur une touche pour lancer le de");

            sc.nextLine();
            gameState = warriors.nextTurn(gameId);
        }

        System.out.println(gameState.getLastLog());
    }


    private static void serialyze(RootMap map){


        //Gson gson = new Gson();
        //String Result =  gson.toJson(map);
       //System.out.println(Result);

        String jsonMapObject = "";
        GsonBuilder gson2 = new GsonBuilder();


        gson2.registerTypeAdapter(Content.class, new MyContentSerializer());
        Gson gson3 =  gson2.create();

        jsonMapObject = gson3.toJson(map);
        System.out.println(jsonMapObject);
                //.fromJson(jsonData, RootMap.class);


    }

    private static Map deserialyzed(String path){
        String jsonData = "";
        RootMap jsonMapGenerated = null;
        GsonBuilder gson2 = new GsonBuilder();

        gson2.registerTypeAdapter(Content.class, new MyContentDeserializer());
        Gson gson3 =  gson2.create();


        try {
            BufferedReader fichier_source = new BufferedReader(new FileReader(path));

            String line;
            while ((line = fichier_source.readLine()) != null) {
                jsonData+=line;
            }

            // test custom
            jsonMapGenerated = gson3.fromJson(jsonData, RootMap.class);


        } catch (IOException e) {
            e.printStackTrace();
        }



        return jsonMapGenerated;
    }


    private static ArrayList<Integer> csvToArraylist(String path) {

        ArrayList<Integer> temp = new ArrayList<>();

        try {
            BufferedReader fichier_source = new BufferedReader(new FileReader(path));
            String line;
            while ((line = fichier_source.readLine()) != null) {
                temp.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    private static String displayMenu(Scanner sc) {
        System.out.println();
        System.out.println("================== Java Warriors ==================");
        System.out.println("1 - Commencer une partie");
        System.out.println("2 - Quitter");
        if (sc.hasNext()) {
            String choice = sc.nextLine();
            return choice;
        }

        return "";
    }
}


