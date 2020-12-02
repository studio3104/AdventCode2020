package com.studio3104.adventofcode2020.day01;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem2 {
    private static int[] getNumsOfThreeSum(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            int[] twoSum = Problem1.getNumsOfTwoSum(nums, i, 2020 - n);

            if (twoSum[0] != 0 || twoSum[1] != 0) {
                return new int[]{n, twoSum[0], twoSum[1]};
            }
        }

        return new int[]{0, 0, 0};
    }

    private static int getResult(int[] nums) {
        int[] threeSum = getNumsOfThreeSum(nums);
        return Arrays.stream(threeSum).reduce(1, (n, m) -> n * m);
    }

    public static void main(String[] args) {
        System.out.println(Problem2.getResult(InputLoader.loadIntegerInput(1)));
    }
}
