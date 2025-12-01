package Backend;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hw.serpapi.GoogleSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class APIIntegration {

    public static ArrayList<Event> Search(String searchString){

        String apiKey = "0608051e2ed3b6fd1431a3e7478fb925dd825895e331405a3bfb1ef148495292";

        ArrayList<Event>events=new ArrayList<>();

        Map<String,String> parameter = new HashMap<>();
        parameter.put("engine","google_events");
        parameter.put("q",searchString);
        parameter.put("google_domain","google.com");
        parameter.put("gl","uk");
        parameter.put("api_key", apiKey);

        GoogleSearch search = new GoogleSearch(parameter);

        try{
            JsonObject results=search.getJson();
            var eventResults=results.get("event_results");
            for (String key : results.keySet()) {
                if (key.equals("event_results")) {
                    JsonArray asJasonArray = results.get(key).getAsJsonArray();

                    for (JsonElement jsonElement : asJasonArray) {
                        String title = JsonTools.getValue(jsonElement, SearchID.TITLE).toString();
                        JsonElement date = JsonTools.getValue(jsonElement, SearchID.DATE);
                        String venue = JsonTools.getValue(jsonElement, SearchID.VENUE).toString();
                        Event event = new Event(title, date, venue);
                        events.add(event);
                        //System.out.println(jsonElement);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return events;
    }


}
