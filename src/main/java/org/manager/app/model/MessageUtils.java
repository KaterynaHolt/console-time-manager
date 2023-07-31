package org.manager.app.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.manager.app.service.PeriodsStore;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageUtils {
    private final Logger logger = LogManager.getLogger(MessageUtils.class);
    private PeriodsStore periods;
    private Locale locale;
    public MessageUtils(PeriodsStore periods, Locale locale){
        this.periods = periods;
        this.locale = locale;
    }

    /**
     * This method gets greeting for user
     * @param number - index for list of periods
     * @return - greeting for user on language of current locale or default language
     */
    public String getGreeting(int number){
        ResourceBundle bundle = ResourceBundle.getBundle("languages.Language", this.locale);
        String period = this.periods.getPeriods().get(number).getPeriod();
        int low = this.periods.getPeriods().get(number).getLowLimit();
        int high = this.periods.getPeriods().get(number).getHighLimit();
        String result = bundle.getString(period) + " - " + low + ":00 - " + high + ":00";
        return result;
    }

    /**
     * This method print greeting for user and make some logs
     * @param str - greeting for user
     */
    public void printMessage(String str){
        System.out.println("\n" + str + "\n");
        this.logger.info("User's locale: " + this.locale + ", Greeting for user: " + str);
    }
}
