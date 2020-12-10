package com.studio3104.adventofcode2020.day10;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    static long getResult(long[] nums) {
        Arrays.sort(nums);

        long device = Integer.MIN_VALUE;
        long[] adapters = new long[nums.length + 2];

        for (int i = 0; i < nums.length; ++i) {
            adapters[i + 1] = nums[i];
            device = Math.max(device, nums[i]);
        }

        adapters[adapters.length - 1] = device + 3;

        long[] dp = new long[adapters.length];

        for (int i = 0; i < adapters.length; ++i) {
            long a = adapters[i];
            long b = a + 1, c = a + 2, d = a + 3;

            for (int j = i + 1; j <= i + 3 && j < adapters.length; ++j) {
                long e = adapters[j];
                if (e == b || e == c || e == d) {
                    dp[j] += Math.max(1, dp[i]);
                }
            }
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadLongInput(10)));
    }
}
