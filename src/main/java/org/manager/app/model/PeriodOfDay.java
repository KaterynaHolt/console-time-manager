package org.manager.app.model;

public class PeriodOfDay {
    private int lowLimit;
    private int highLimit;
    private String period;
    public PeriodOfDay(int lowLimit, int highLimit, String period){
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
        this.period = period;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public int getHighLimit() {
        return highLimit;
    }

    public String getPeriod() {
        return period;
    }
}
