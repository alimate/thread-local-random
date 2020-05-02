package me.alidg;

import java.util.Random;

public class MyThreadLocalRandom extends Random {

    private long seed = System.nanoTime();
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
    private static final ThreadLocal<MyThreadLocalRandom> threadLocal = ThreadLocal.withInitial(MyThreadLocalRandom::new);

    private MyThreadLocalRandom() {}

    public static MyThreadLocalRandom current() {
        return threadLocal.get();
    }

    @Override
    protected int next(int bits) {
        seed = (seed * multiplier + addend) & mask;
        return (int) (seed >>> (48 - bits));
    }
}
