package com.sda.counter;

/**
 * Created by bartosz on 23.06.2017.
 */
public class CounterSummaryService {
    private static CounterSummaryService ourInstance = new CounterSummaryService();

    public static CounterSummaryService getInstance() {
        return ourInstance;
    }

    private CounterSummaryService() {
    }
}
