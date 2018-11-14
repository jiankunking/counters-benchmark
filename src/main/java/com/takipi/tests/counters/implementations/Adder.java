package com.takipi.tests.counters.implementations;

import com.takipi.tests.counters.Counter;

import java.util.concurrent.atomic.LongAdder;

public class Adder implements Counter {
    private final LongAdder adder = new LongAdder();

    @Override
    public long getCounter() {
        return adder.longValue();
    }

    @Override
    public void increment() {
        adder.increment();
    }
}
