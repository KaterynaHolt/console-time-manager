package org.manager.app.starter;

import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;


public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int period = getPeriod(hour);
        Locale currentLocale = Locale.getDefault();
        Locale.setDefault(new Locale("en", "GB"));
        //Locale locale = new Locale("af", "ZA");
        Locale locale = currentLocale;
        ResourceBundle bundle = ResourceBundle.getBundle("resources", locale);
        switch (period){
            case 1:
                System.out.println(bundle.getString("morning") + " - 6:00 - 9:00");
            case 2:
                System.out.println(bundle.getString("day") + " - 9:00 - 19:00");
            case 3:
                System.out.println(bundle.getString("evening") + " - 19:00 - 23:00");
            case 4:
                System.out.println(bundle.getString("night") + " - 23:00 - 6:00");
        }
    }

    public static int getPeriod(int hour){
        int period = 0;
        if(hour >= 6 && hour < 9)
            period = 1;
        else if (hour >= 9 && hour < 19)
            period = 2;
        else if (hour >= 19 && hour < 23)
            period = 3;
        else
            period = 4;
        return period;
    }
}