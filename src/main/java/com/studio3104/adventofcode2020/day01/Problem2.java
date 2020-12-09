package com.studio3104.adventofcode2020.day01;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem2 {
    private static long[] getNumsOfThreeSum(long[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            long n = nums[i];
            long[] twoSum = Problem1.getNumsOfTwoSum(nums, i + 1, nums.length, 2020 - n);

            if (twoSum[0] != 0 || twoSum[1] != 0) {
                return new long[]{n, twoSum[0], twoSum[1]};
            }
        }

        return new long[]{0, 0, 0};
    }

    private static long getResult(long[] nums) {
        long[] threeSum = getNumsOfThreeSum(nums);
        return Arrays.stream(threeSum).reduce(1, (n, m) -> n * m);
    }

    public static void main(String[] args) {
        System.out.println(Problem2.getResult(InputLoader.loadLongInput(1)));
    }
}
