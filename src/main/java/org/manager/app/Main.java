package org.manager.app;


import java.awt.*;
import java.awt.im.InputContext;
import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalTime time = LocalTime.now();
        int hour = time.getHour();

        System.out.println(time);

        Locale locale = new Locale("de", "UA");
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, locale).format(new Date()));

        System.out.println(hour);

        

    }
}