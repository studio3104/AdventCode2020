package com.studio3104.adventofcode2020.day09;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem2 {
    private static long sumMinMax(Deque<Long> q) {
        long smallest = Long.MAX_VALUE;
        long largest = Long.MIN_VALUE;

        for (long n : q) {
            smallest = Math.min(smallest, n);
            largest = Math.max(largest, n);
        }

        return smallest + largest;
    }

    static long getResult(long[] nums, int len) {
        Deque<Long> q = new ArrayDeque<>();
        long sum = 0;
        long exception = Problem1.getResult(nums, len);

        for (long n : nums) {
            sum += n;
            q.addLast(n);

            while (!q.isEmpty() && sum > exception) {
                sum -= q.pollFirst();
            }

            if (sum == exception) {
                return sumMinMax(q);
            }
        }

        throw new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadLongInput(9), 25));
    }
}
