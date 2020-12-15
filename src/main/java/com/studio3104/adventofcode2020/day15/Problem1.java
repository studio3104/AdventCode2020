package com.studio3104.adventofcode2020.day15;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    static int getResult(int[] nums) {
        Map<Integer, int[]> log = new HashMap<>();
        int turn = 1;
        int last = 0;

        for (; turn <= nums.length; ++turn) {
            int n = nums[turn - 1];
            last = n;
            log.put(n, new int[]{0, turn});
        }

        for (; turn <= 2020; ++turn) {
            int[] t = log.get(last);
            last = t[0] == 0 ? 0 : t[1] - t[0];

            t = log.getOrDefault(last, new int[2]);
            t[0] = t[1];
            t[1] = turn;
            log.put(last, t);
        }

        return last;
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{2, 0, 1, 9, 5, 19}));
    }
}
