package org.manager.app.starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.manager.app.model.Message;
import java.util.Locale;


public class MainTest {
    /**
     * This method tests getting period og the day - getPeriod
     */
    @Test
    public void test_getting_period(){
        //GIVEN
        String periodMorning;
        String periodDay;
        String periodEvening;
        String periodNight;
        int hourMorning = 7;
        int hourDay = 13;
        int hourEvening = 21;
        int hourNight = 1;
        //WHEN
        periodMorning = Main.getPeriod(hourMorning);
        periodDay = Main.getPeriod(hourDay);
        periodEvening = Main.getPeriod(hourEvening);
        periodNight = Main.getPeriod(hourNight);
        //THEN
        Assertions.assertEquals("morning", periodMorning);
        Assertions.assertEquals("day", periodDay);
        Assertions.assertEquals("evening", periodEvening);
        Assertions.assertEquals("night", periodNight);
    }

    /**
     * This method tests getting greeting to user - getGreeting
     */
    @Test
    public void test_getting_bundle_by_locale(){
        //GIVEN
        Message message = new Message();
        Locale localeUA = new Locale("uk", "UA");
        Locale localeGB = new Locale("en", "GB");
        Locale localeRU = new Locale("ru", "RU");
        Locale localeZA = new Locale("af", "ZA");
        String periodUA = "morning";
        String periodGB = "day";
        String periodRU = "evening";
        String periodZA = "night";
        Locale.setDefault(new Locale("en", "GB"));
        //WHEN
        String resultUA = Main.getGreeting(localeUA, periodUA, message.getTimePeriod().get(0));
        String resultGB = Main.getGreeting(localeGB, periodGB, message.getTimePeriod().get(1));
        String resultRU = Main.getGreeting(localeRU, periodRU, message.getTimePeriod().get(2));
        String resultZA = Main.getGreeting(localeZA, periodZA, message.getTimePeriod().get(3));
        //THEN
        Assertions.assertEquals("Доброго ранку, Світ! - 6:00 - 9:00", resultUA);
        Assertions.assertEquals("Good day, World! - 9:00 - 19:00", resultGB);
        Assertions.assertEquals("Добрий вечер, Мир! - 19:00 - 23:00", resultRU);
        Assertions.assertEquals("Good night, World! - 23:00 - 6:00", resultZA);
    }
}
