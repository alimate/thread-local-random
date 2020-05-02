package me.alidg;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.openjdk.jmh.annotations.Mode.Throughput;

@Threads(8)
@Fork(value = 2)
@Warmup(iterations = 5)
@State(Scope.Benchmark)
public class RandomBenchmark {

    private final Random random = new Random();
    private final ThreadLocal<Random> simpleThreadLocal = ThreadLocal.withInitial(Random::new);

    @Benchmark
    @BenchmarkMode(Throughput)
    public int regularRandom() {
        return random.nextInt();
    }

    @Benchmark
    @BenchmarkMode(Throughput)
    public int simpleThreadLocal() {
        return simpleThreadLocal.get().nextInt();
    }

    @Benchmark
    @BenchmarkMode(Throughput)
    public int builtinThreadLocal() {
        return ThreadLocalRandom.current().nextInt();
    }

    @Benchmark
    @BenchmarkMode(Throughput)
    public int lockFreeThreadLocal() {
        return MyThreadLocalRandom.current().nextInt();
    }

    public static void main(String[] args) throws Exception {
        org.openjdk.jmh.Main.main(args);
    }
}
