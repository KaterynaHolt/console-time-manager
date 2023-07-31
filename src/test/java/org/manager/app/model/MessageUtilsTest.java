package org.manager.app.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.manager.app.service.PeriodsStore;

import java.util.Locale;

public class MessageUtilsTest {
    /**
     * This method tests getting greeting to user - getGreeting
     */
    @Test
    public void test_getting_greeting(){
        //GIVEN
        PeriodsStore periodsStore = new PeriodsStore();
        Locale localeUA = new Locale("uk", "UA");
        Locale localeGB = new Locale("en", "GB");
        Locale localeRU = new Locale("ru", "RU");
        Locale localeZA = new Locale("af", "ZA");
        Locale.setDefault(new Locale("en", "GB"));
        MessageUtils messUA = new MessageUtils(periodsStore, localeUA);
        MessageUtils messGB = new MessageUtils(periodsStore, localeGB);
        MessageUtils messRU = new MessageUtils(periodsStore, localeRU);
        MessageUtils messZA = new MessageUtils(periodsStore, localeZA);
        //WHEN
        String resultUA = messUA.getGreeting(0);
        String resultGB = messGB.getGreeting(1);
        String resultRU = messRU.getGreeting(2);
        String resultZA = messZA.getGreeting(3);
        //THEN
        Assertions.assertEquals("Доброго ранку, Світ! - 6:00 - 9:00", resultUA);
        Assertions.assertEquals("Good day, World! - 9:00 - 19:00", resultGB);
        Assertions.assertEquals("Добрий вечер, Мир! - 19:00 - 23:00", resultRU);
        Assertions.assertEquals("Good night, World! - 23:00 - 6:00", resultZA);
    }
}
