package Backend;

import com.google.gson.JsonElement;

public class JsonTools {

    public static JsonElement getValue(JsonElement element, SearchID id){
        return element.getAsJsonObject().get(id.name().toLowerCase());
    }
}
