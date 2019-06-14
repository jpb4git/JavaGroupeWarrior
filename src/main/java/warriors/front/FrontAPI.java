package warriors.front;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import warriors.contracts.GameState;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FrontAPI {

    //GET
    public String currentGame() {
        String jsonData = "";


        BufferedReader fichier_source = null;
        try {


            fichier_source = new BufferedReader(new FileReader("/GameWarrior_JSON.json"));
            String line;
            while ((line = fichier_source.readLine()) != null) {
                jsonData += line;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





        return jsonData;
    }

    //POST
    public GameStateAPI nextTurn(String jsonData) {
        System.out.println(jsonData);
        String jsonDataString = "";
        BufferedReader fichier_source = null;
        try {


            fichier_source = new BufferedReader(new FileReader(jsonData));
            String line;
            while ((line = fichier_source.readLine()) != null) {
                jsonDataString += line;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Gson gson = new Gson();

         GameStateAPI gs  = gson.fromJson(jsonDataString,GameStateAPI.class);
         //return gson.toJson(gs);
        return gs;
    }




}
