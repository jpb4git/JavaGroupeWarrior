package warriors.client.console;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import com.google.gson.Gson;
import warriors.contracts.GameState;
import warriors.contracts.GameStatus;
import warriors.contracts.Hero;
import warriors.contracts.Map;
import warriors.contracts.WarriorsAPI;
import warriors.engine.Warriors;

public class ClientConsole {

    private static String MENU_COMMENCER_PARTIE = "1";
    private static String MENU_QUITTER = "2";


    public static void main(String[] args) {



        ArrayList<Integer> scenario = null;
        if(args.length > 0){
            scenario =  csvToArraylist(args[0]);
        }
        WarriorsAPI warriors = new Warriors(scenario);
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


        Gson gson = new Gson();
        String Result =  gson.toJson(gameState.getMap());
        System.out.println(Result);

        while (gameState.getGameStatus() == GameStatus.IN_PROGRESS) {
            System.out.println(gameState.getLastLog());
            System.out.println("\nAppuyer sur une touche pour lancer le de");

            sc.nextLine();
            gameState = warriors.nextTurn(gameId);
        }

        System.out.println(gameState.getLastLog());
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

