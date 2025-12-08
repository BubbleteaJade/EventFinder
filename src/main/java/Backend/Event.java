package Backend;

import com.google.gson.JsonElement;

public class Event {
    String location;
    String date;
    String dayANDtime;
    String venue;

    public Event(String location, JsonElement date, String venue) {
        this.location = location;
        this.date = JsonTools.getValue(date,SearchID.START_DATE).toString();
        this.dayANDtime=JsonTools.getValue(date,SearchID.WHEN).toString();
        this.venue = venue;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getDayANDtime(){return dayANDtime;}

    public String getVenue() {
        return venue;
    }
}
