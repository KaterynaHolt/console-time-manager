package org.manager.app.starter;

import java.awt.*;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.manager.app.model.MessageUtils;
import org.manager.app.service.PeriodsStore;


public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        PeriodsStore periodsStore = new PeriodsStore();
        MessageUtils messageUtils = new MessageUtils(periodsStore, Locale.getDefault());
        int hour = LocalTime.now().getHour();
        String period = periodsStore.getPeriod(hour);
        Locale.setDefault(new Locale("en", "GB"));
        switch (period){
            case "morning":
                String resultM = messageUtils.getGreeting(0);
                messageUtils.printMessage(resultM);
                break;
            case "day":
                String resultD = messageUtils.getGreeting(1);
                messageUtils.printMessage(resultD);
                break;
            case "evening":
                String resultE = messageUtils.getGreeting(2);
                messageUtils.printMessage(resultE);
                break;
            case "night":
                String resultN = messageUtils.getGreeting(3);
                messageUtils.printMessage(resultN);
                break;
        }
    }
}