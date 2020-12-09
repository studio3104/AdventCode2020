package com.studio3104.adventofcode2020.day09;

import com.studio3104.adventofcode2020.utilities.InputLoader;

public class Problem2 {
    private static long sumMinMax(long[] nums, int left, int right) {
        long smallest = Long.MAX_VALUE;
        long largest = Long.MIN_VALUE;

        for (int i = left; i <= right; ++i) {
            smallest = Math.min(smallest, nums[i]);
            largest = Math.max(largest, nums[i]);
        }

        return smallest + largest;
    }

    static long getResult(long[] nums, int len) {
        long sum = nums[0];
        long exception = Problem1.getResult(nums, len);
        int left = 0, right = 0;

        while (sum != exception) {
            sum += sum < exception ? nums[++right] : nums[left++] * -1;
        }

        return sumMinMax(nums, left, right);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadLongInput(9), 25));
    }
}
