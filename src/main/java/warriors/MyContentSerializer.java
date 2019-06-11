package warriors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import warriors.items.Blank;
import warriors.items.Potion;
import warriors.items.Spell;
import warriors.items.Weapon;
import warriors.mobs.Mob;

import java.lang.reflect.Type;

public class MyContentSerializer implements JsonSerializer<Content> {



    @Override
    public JsonElement serialize(Content content, Type type, JsonSerializationContext jsonSerializationContext) {

        JsonObject jsonContent = new JsonObject();
        String jsonType = content.getClass().getSimpleName();

        jsonContent.addProperty("type" , jsonType);
        jsonContent.addProperty("name" , content.getName());
        jsonContent.addProperty("tileToClear" , false);


        System.out.println(jsonType);

        switch (jsonType) {
            case "Potion":
                jsonContent.addProperty("healPts" , ((Potion)content).getHealPts());
                break;
            case "Spell":
                jsonContent.addProperty("attackBonus" , ((Spell)content).getAttackBonus());
                break;
            case "Weapon":
                jsonContent.addProperty("attackBonus" , ((Weapon)content).getAttackBonus());
                break;
            case "Mob":
                jsonContent.addProperty("healthPts" , ((Mob)content).getHealthPts());
                jsonContent.addProperty("attackPts" , ((Mob)content).getAttackPts());
                break;
        }

        return jsonContent;
    }
}
