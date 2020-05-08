Thread Local Randoms in Java
---
This is the companion repository for this [post](https://alidg.me/blog/2020/4/24/thread-local-random) to demonstrate how well the `ThreadLocalRandom` class can perform compared to a few other random generation strategies.

Benchmark
---
Here is the JMH result for different random generation strategies:
```plain
Benchmark                             Mode  Cnt           Score          Error  Units
RandomBenchmark.builtinThreadLocal   thrpt   40  1023676193.004 ± 26617584.814  ops/s
RandomBenchmark.lockFreeThreadLocal  thrpt   40   695217843.076 ± 17455041.160  ops/s
RandomBenchmark.regularRandom        thrpt   40     7487301.035 ±   244268.309  ops/s
RandomBenchmark.simpleThreadLocal    thrpt   40   382674281.696 ± 13197821.344  ops/s
```