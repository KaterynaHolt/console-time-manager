package org.manager.app.model;

public class PeriodOfDay {
    private final int lowLimit;
    private final int highLimit;
    private final String period;
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
