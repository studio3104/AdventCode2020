package com.studio3104.adventofcode2020.day1;

import java.util.Arrays;

public class Problem2 extends Problem1 {
    private int[] getNumsOfThreeSum(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int n = nums[i];
            int sumTo = this.SUMTO - n;
            int[] twoSum = getNumsOfTwoSum(nums, i, sumTo);

            if (twoSum[0] != 0 || twoSum[1] != 0) {
                return new int[]{n, twoSum[0], twoSum[1]};
            }
        }

        return new int[]{0, 0, 0};
    }

    public int getResult(int[] nums) {
        int[] threeSum = getNumsOfThreeSum(nums);
        return Arrays.stream(threeSum).reduce(1, (n, m) -> n * m);
    }

    public static void main(String[] args) {
        Problem2 problem = new Problem2();
        System.out.println(problem.getResult(problem.input));
    }
}
