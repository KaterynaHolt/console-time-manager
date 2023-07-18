package org.manager.app.starter;

import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.manager.app.model.Message;


public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        Message message = new Message();
        int hour = message.getTime().getHour();
        String period = getPeriod(hour);
        Locale.setDefault(new Locale("en", "GB"));
        Locale locale = message.getLocale();
        switch (period){
            case "morning":
                String resultM = getGreeting(locale, period, message.getTimePeriod().get(0));
                System.out.println("\n" + resultM + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultM);
                break;
            case "day":
                String resultD = getGreeting(locale, period, message.getTimePeriod().get(1));
                System.out.println("\n" + resultD + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultD);
                break;
            case "evening":
                String resultE = getGreeting(locale, period, message.getTimePeriod().get(2));
                System.out.println("\n" + resultE + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultE);
                break;
            case "night":
                String resultN = getGreeting(locale, period, message.getTimePeriod().get(3));
                System.out.println("\n" + resultN + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultN);
                break;
        }
    }

    /**
     * This method gives user period of the day
     * @param hour - hour of current time
     * @return period of the day
     */
    public static String getPeriod(int hour){
        String period;
        if(hour >= 6 && hour < 9)
            period = "morning";
        else if (hour >= 9 && hour < 19)
            period = "day";
        else if (hour >= 19 && hour < 23)
            period = "evening";
        else
            period = "night";
        return period;
    }

    /**
     * This method gets greeting to user
     * @param locale - current locale
     * @param period - period of the day
     * @param timePeriod - hours for period
     * @return greeting for user on language of current locale or default language
     */
    public static String getGreeting(Locale locale, String period, String timePeriod){
        ResourceBundle bundle = ResourceBundle.getBundle("languages.Language", locale);
        String result = bundle.getString(period) + " - " + timePeriod;
        return result;
    }
}