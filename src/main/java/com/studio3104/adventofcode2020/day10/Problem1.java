package com.studio3104.adventofcode2020.day10;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem1 {
    static int getResult(int[] nums) {
        Arrays.sort(nums);
        int c1 = 1, c3 = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] - nums[i - 1] == 1) {
                ++c1;
            } else {
                ++c3;
            }
        }

        return c1 * c3;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadIntegerInput(10)));
    }
}
