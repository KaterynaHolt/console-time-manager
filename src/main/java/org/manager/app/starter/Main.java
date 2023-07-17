package org.manager.app.starter;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        String period = getPeriod(hour);
        Locale currentLocale = Locale.getDefault();
        Locale.setDefault(new Locale("en", "GB"));
        //Locale locale = new Locale("en", "US");
        Locale locale = currentLocale;
        switch (period){
            case "morning":
                String resultM = getBundleByLocale(locale, period) + " - 6:00 - 9:00";
                System.out.println("\n" + resultM + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultM);
                break;
            case "day":
                String resultD = getBundleByLocale(locale, period) + " - 9:00 - 19:00";
                System.out.println("\n" + resultD + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultD);
                break;
            case "evening":
                String resultE = getBundleByLocale(locale, period) + " - 19:00 - 23:00";
                System.out.println("\n" + resultE + "\n");
                logger.info("User's locale: " + locale + ", Greeting for user: " + resultE);
                break;
            case "night":
                String resultN = getBundleByLocale(locale, period) + " - 23:00 - 6:00";
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
     * This method gives user bundle by locale
     * @param locale - current locale
     * @param period - period of the day
     * @return string on language of current locale or default language
     */
    public static String getBundleByLocale(Locale locale, String period){
        ResourceBundle bundle = ResourceBundle.getBundle("resources", locale);
        return bundle.getString(period);
    }
}