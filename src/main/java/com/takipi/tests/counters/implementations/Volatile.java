package com.takipi.tests.counters.implementations;

import com.takipi.tests.counters.Counter;

public class Volatile implements Counter {
    private volatile long counter;

    @Override
    public long getCounter() {
        return counter;
    }

    @Override
    public void increment() {
        ++counter;
    }
}