package org.manager.app.starter;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.manager.app.service.PeriodsStore;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        PeriodsStore periodsStore = new PeriodsStore();
        int hour = LocalTime.now().getHour();
        Locale locale = Locale.getDefault();
        String period = periodsStore.getPeriod(hour);
        Locale.setDefault(new Locale("en", "GB"));
        switch (period){
            case "morning":
                String resultM = getGreeting(locale, periodsStore, 0);
                printMessage(locale, resultM);
                break;
            case "day":
                String resultD = getGreeting(locale, periodsStore, 1);
                printMessage(locale, resultD);
                break;
            case "evening":
                String resultE = getGreeting(locale, periodsStore, 2);
                printMessage(locale, resultE);
                break;
            case "night":
                String resultN = getGreeting(locale, periodsStore, 3);
                printMessage(locale, resultN);
                break;
        }
    }

    /**
     * This method gets greeting for user
     * @param locale - current locale
     * @param periods - periods of the day
     * @param number - index for list of periods
     * @return - greeting for user on language of current locale or default language
     */
    public static String getGreeting(Locale locale, PeriodsStore periods, int number){
        ResourceBundle bundle = ResourceBundle.getBundle("languages.Language", locale);
        String period = periods.getPeriods().get(number).getPeriod();
        int low = periods.getPeriods().get(number).getLowLimit();
        int high = periods.getPeriods().get(number).getHighLimit();
        String result = bundle.getString(period) + " - " + low + ":00 - " + high + ":00";
        return result;
    }

    /**
     * This method print greeting for user and make some logs
     * @param locale - current locale
     * @param str - greeting for user
     */
    public static void printMessage(Locale locale, String str){
        System.out.println("\n" + str + "\n");
        logger.info("User's locale: " + locale + ", Greeting for user: " + str);
    }
}