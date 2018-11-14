package com.takipi.tests.counters.implementations;

import com.takipi.tests.counters.Counter;

public class Dirty implements Counter {
    private long counter;

    @Override
    public long getCounter() {
        return counter;
    }
    @Override
    public void increment() {
        ++counter;
    }
}
