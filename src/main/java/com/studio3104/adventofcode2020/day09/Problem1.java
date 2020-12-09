package com.studio3104.adventofcode2020.day09;

import com.studio3104.adventofcode2020.utilities.InputLoader;

public class Problem1 {
    static long getResult(long[] nums, int len) {
        for (int i = len; i < nums.length; ++i) {
            long[] twoSum = com.studio3104.adventofcode2020.day01.Problem1.getNumsOfTwoSum(
                    nums, i - len, i, nums[i]
            );
            if (twoSum[0] == 0 && twoSum[1] == 0) {
                return nums[i];
            }
        }

        throw new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadLongInput(9), 25));
    }
}
