package com.studio3104.adventofcode2020.day10;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    static long getResult(long[] adapters) {
        long device = Integer.MIN_VALUE;
        Map<Long, Integer> indexOf = new HashMap<>();

        for (int i = 0; i < adapters.length; ++i) {
            long a = adapters[i];
            device = Math.max(device, a);
            indexOf.put(a, i + 1);
        }

        device += 3;
        indexOf.put((long) 0, 0);
        indexOf.put(device, adapters.length + 1);

        long[] dp = new long[adapters.length + 2];

        for (long a : indexOf.keySet().stream().sorted().toArray(Long[]::new)) {
            for (long n = a + 1; n <= a + 3; ++n) {
                if (indexOf.containsKey(n)) {
                    dp[indexOf.get(n)] += Math.max(1, dp[indexOf.get(a)]);
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadLongInput(10)));
    }
}
