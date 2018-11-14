package com.takipi.tests.counters.implementations;

import com.takipi.tests.counters.Counter;

import java.util.concurrent.locks.StampedLock;

public class OptimisticStamped implements Counter {

    private StampedLock rwlock = new StampedLock();

    private long counter;
    private long success;

    private long total;

    @Override
    public long getCounter() {
        long stamp = rwlock.tryOptimisticRead();
        total++;
        long temp = counter;
        if (rwlock.validate(stamp)) {
            success++;
            return temp;
        } else {
            try {
                success++;
                // 读入本地变量
                stamp = rwlock.readLock();
                return counter;
            } finally {
                rwlock.unlockRead(stamp);
            }
        }
    }

    @Override
    public void increment() {
        long stamp = rwlock.writeLock();
        try {
            ++counter;
        } finally {
            rwlock.unlockWrite(stamp);
        }
    }

    public long getSuccess() {
        return success;
    }


    public long getTotal() {
        return total;
    }
}
