package org.manager.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeriodsStoreTest {
    /**
     * This method tests getting period of day - getPeriod
     */
    @Test
    public void test_getting_period_of_day(){
        //GIVEN
        PeriodsStore periodsStore = new PeriodsStore();
        int hourM = 7;
        int hourD = 13;
        int hourE = 21;
        int hourN = 3;
        //WHEN
        String resultM = periodsStore.getPeriod(hourM);
        String resultD = periodsStore.getPeriod(hourD);
        String resultE = periodsStore.getPeriod(hourE);
        String resultN = periodsStore.getPeriod(hourN);
        //THEN
        Assertions.assertEquals("morning", resultM);
        Assertions.assertEquals("day", resultD);
        Assertions.assertEquals("evening", resultE);
        Assertions.assertEquals("night", resultN);
    }
}
