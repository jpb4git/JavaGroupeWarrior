package warriors;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class MyContentSerializer implements JsonSerializer<Content> {



    @Override
    public JsonElement serialize(Content content, Type type, JsonSerializationContext jsonSerializationContext) {

        String c = content.getName();
        System.out.println(c);

        return null;
    }
}
