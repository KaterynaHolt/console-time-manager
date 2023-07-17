package org.manager.app.starter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
     * This method tests getting bundle by locale - getBundleByLocale
     */
    @Test
    public void test_getting_bundle_by_locale(){
        //GIVEN
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
        String resultUA = Main.getBundleByLocale(localeUA, periodUA);
        String resultGB = Main.getBundleByLocale(localeGB, periodGB);
        String resultRU = Main.getBundleByLocale(localeRU, periodRU);
        String resultZA = Main.getBundleByLocale(localeZA, periodZA);
        //THEN
        Assertions.assertEquals("Доброго ранку, Світ!", resultUA);
        Assertions.assertEquals("Good day, World!", resultGB);
        Assertions.assertEquals("Добрий вечер, Мир!", resultRU);
        Assertions.assertEquals("Good night, World!", resultZA);
    }
}
