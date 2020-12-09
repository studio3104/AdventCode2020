package com.studio3104.adventofcode2020.day01;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    public static long[] getNumsOfTwoSum(long[] nums, int head, int tail, long sumTo) {
        Set<Long> set = new HashSet<>();

        for (int j = head; j < tail; ++j) {
            long n = nums[j];
            long toFind = sumTo - n;

            if (set.contains(toFind)) {
                return new long[]{n, toFind};
            }

            set.add(n);
        }

        return new long[]{0, 0};
    }

    private static long getResult(long[] nums) {
        long[] twoSum = getNumsOfTwoSum(nums, 0, nums.length, 2020);
        return twoSum[0] * twoSum[1];
    }

    public static void main(String[] args) {
        System.out.println(Problem1.getResult(InputLoader.loadLongInput(1)));
    }
}
