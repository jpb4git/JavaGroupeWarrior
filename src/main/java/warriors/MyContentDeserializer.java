package warriors;

import com.google.gson.*;
import warriors.items.Blank;
import warriors.items.Spell;
import warriors.items.Weapon;
import warriors.mobs.Mob;

import java.lang.reflect.Type;

public class MyContentDeserializer implements JsonDeserializer<Content> {

    @Override
    public Content deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        //String typeAbstract = jsonElement.

        JsonObject jsEl = jsonElement.getAsJsonObject();

        String typeAbstract = jsEl.get("type").getAsString(); // .getAsString instead of .toString to avoid ""Blank"" and give "Blank"

        Content newContent;

        switch (typeAbstract) {
            case "Potion":
                newContent = new Weapon(jsEl.get("name").getAsString(), jsEl.get("healPts").getAsInt());
            break;
            case "Spell":
                newContent =  new Spell(jsEl.get("name").getAsString(), jsEl.get("attackBonus").getAsInt());
            break;
            case "Weapon":
                newContent =  new Weapon(jsEl.get("name").getAsString(), jsEl.get("attackBonus").getAsInt());
            break;
            case "Mob":
                newContent =  new Mob(jsEl.get("name").getAsString(), jsEl.get("healthPts").getAsInt(), jsEl.get("attackPts").getAsInt());
            break;
            default:
                newContent =  new Blank(jsEl.get("name").getAsString());
            break;
        }
        return newContent;

    }


}
