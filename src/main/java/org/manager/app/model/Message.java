package org.manager.app.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Message {
    private final LocalTime time;
    private final Locale locale;
    private final List<String> timePeriod = new ArrayList<>();
    public Message(){
        this.time = LocalTime.now();
        this.locale = Locale.getDefault();
        this.timePeriod.add("6:00 - 9:00");
        this.timePeriod.add("9:00 - 19:00");
        this.timePeriod.add("19:00 - 23:00");
        this.timePeriod.add("23:00 - 6:00");
    }

    public LocalTime getTime(){
        return time;
    }

    public Locale getLocale() {
        return locale;
    }

    public List<String> getTimePeriod(){
        return timePeriod;
    }
}
