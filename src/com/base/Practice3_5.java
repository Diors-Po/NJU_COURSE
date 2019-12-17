package com.base;

import java.util.*;

/**
 * @author: Diors.Po
 * @Email: 171256175@qq.com
 * @date 2019-10-31 10:22
 */
public class Practice3_5 {
    private static final int MOD = 1_000_000_000 + 7;

    public static void main(String[] args) {
        Map<Long, Integer> cache = new HashMap<>();
        cache.put(0L, 0);
        cache.put(1L, 1);
        cache.put(2L, 1);

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long n = in.nextLong();
            System.out.println(f(n + 1, cache));
        }
    }

    private static int f(long n, Map<Long, Integer> cache) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long t;
        if (n % 2 == 0) {
            long fn = f(n / 2, cache);
            long fn1 = f(n / 2 + 1, cache);
            long d = (2 * fn1 - fn);
            if (d < 0) {
                d += MOD;
            }
            t = fn * d;
        } else {
            long fn = f(n / 2, cache);
            long fn1 = f(n / 2 + 1, cache);
            t = fn1 * fn1 + fn * fn;
        }

        t %= MOD;
        cache.put(n, (int) t);
        return (int) t;
    }
}
