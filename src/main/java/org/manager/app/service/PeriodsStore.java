package org.manager.app.service;

import org.manager.app.model.PeriodOfDay;

import java.util.ArrayList;
import java.util.List;

public class PeriodsStore {
    private final List<PeriodOfDay> periods = new ArrayList<>();
    public PeriodsStore(){
        this.periods.add(new PeriodOfDay(6, 9, "morning"));
        this.periods.add(new PeriodOfDay(9, 19, "day"));
        this.periods.add(new PeriodOfDay(19, 23, "evening"));
        this.periods.add(new PeriodOfDay(23, 6, "night"));
    }

    public List<PeriodOfDay> getPeriods(){
        return periods;
    }

    /**
     * This method gives user period of the day
     * @param hour - hour of current time
     * @return period of the day
     */
    public String getPeriod(int hour){
        String period = "";
        for (int i = 0; i < periods.size(); i++){
            if(hour >= periods.get(i).getLowLimit() && hour < periods.get(i).getHighLimit()){
                period = periods.get(i).getPeriod();
                break;
            }
            else{
                period = periods.get(i).getPeriod();
            }
        }
        return period;
    }
}
