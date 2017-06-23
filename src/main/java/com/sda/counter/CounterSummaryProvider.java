package com.sda.counter;

/**
 * Created by bartosz on 23.06.2017.
 */
public class CounterSummaryProvider {
    private static CounterSummaryProvider ourInstance = new CounterSummaryProvider();

    public static CounterSummaryProvider getInstance() {
        return ourInstance;
    }

    private CounterSummaryProvider() {
    }
}
