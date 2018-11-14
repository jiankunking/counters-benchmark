counters-benchmark
==================

# 前言


<font color=red size=30>你想要是的稳定，而不是某个时间很强。</font>



# 一、原文
https://blog.takipi.com/java-8-stampedlocks-vs-readwritelocks-and-synchronized/

# Benchmarking

> Benchmarking counters with Java 10
> Win 7 sp1
> i7-6500U CPU @ 2.50GHz

## 1、5个读 5个写
| Dirty | volatile |LongAdder | AtomicLong | OptimisticStamped |ReentrantReadWriteLock |StampedLock |synchronized |
| ------| ------ | ------ | ------ | ------ | ------ | ------ | ------ |
| 1218.8 |3317.4 | 2198.5 | 3520.3 | 41851.9 |54337.4 |35648.1 |7340.8 |
| 1344.1 |3179.8 | 2307.5 | 3706.7 | 26304.5 |62204.5 |52967.9 |7052.8 |
| 1204.1 | 2918.4 |2266 | 3443.1 | 25534.8 |50312.7 |36302.6 |7440.1 |