package Backend;

import com.google.gson.JsonElement;

public class Event {
    String title;
    String date;
    String dayANDtime;
    String venue;

    public Event(String title, JsonElement date, String venue) {
        this.title = title;
        this.date = JsonTools.getValue(date,SearchID.START_DATE).toString();
        this.dayANDtime=JsonTools.getValue(date,SearchID.WHEN).toString();
        this.venue = venue;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getVenue() {
        return venue;
    }
}
