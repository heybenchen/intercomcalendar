package bschen.intercomcalendar.models;

import java.util.List;

public class Response {
    private List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
