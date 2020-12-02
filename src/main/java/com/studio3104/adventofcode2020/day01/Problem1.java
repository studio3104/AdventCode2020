package com.studio3104.adventofcode2020.day01;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    static int[] getNumsOfTwoSum(int[] nums, int i, int sumTo) {
        Set<Integer> set = new HashSet<>();

        for (int j = i + 1; j < nums.length; ++j) {
            int n = nums[j];
            int toFind = sumTo - n;

            if (set.contains(toFind)) {
                return new int[]{n, toFind};
            }

            set.add(n);
        }

        return new int[]{0, 0};
    }

    private static int getResult(int[] nums) {
        int[] twoSum = getNumsOfTwoSum(nums, -1, 2020);
        return twoSum[0] * twoSum[1];
    }

    public static void main(String[] args) {
        System.out.println(Problem1.getResult(InputLoader.loadIntegerInput(1)));
    }
}
