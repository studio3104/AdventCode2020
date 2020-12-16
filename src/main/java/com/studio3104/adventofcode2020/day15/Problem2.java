package com.studio3104.adventofcode2020.day15;

public class Problem2 {
    static int getResult(int[] nums) {
        return Problem1.playGame(nums, 30000000);
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{2, 0, 1, 9, 5, 19}));
    }
}
