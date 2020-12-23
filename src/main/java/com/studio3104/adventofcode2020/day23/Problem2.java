package com.studio3104.adventofcode2020.day23;

import java.util.stream.IntStream;

public class Problem2 {
    static long getResult(int[] input) {
        int[] expanded = IntStream.rangeClosed(1, 1_000_000).toArray();
        System.arraycopy(input, 0, expanded, 0, input.length);

        ListNode current = Problem1.playGame(expanded, 10_000_000);

        return (long) current.val * (long) current.next.val;
    }

    public static void main(String[] args) {
        System.out.println(getResult(new int[]{1, 9, 8, 7, 5, 3, 4, 6, 2}));
    }
}
