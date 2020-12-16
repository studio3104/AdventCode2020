package com.studio3104.adventofcode2020.day15;

public class Problem1 {
    static int playGame(int[] nums, int end) {
        int[] lastOf = new int[end];
        int turn = 1;

        for (; turn < nums.length; ++turn) {
            lastOf[nums[turn - 1]] = turn;
        }
        int previous = nums[nums.length - 1];

        for (; turn < end; ++turn) {
            int l = lastOf[previous];
            lastOf[previous] = turn;
            previous = l == 0 ? 0 : turn - l;
        }

        return previous;
    }

    static int getResult(int[] nums) {
        return playGame(nums, 2020);
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{2, 0, 1, 9, 5, 19}));
    }
}
