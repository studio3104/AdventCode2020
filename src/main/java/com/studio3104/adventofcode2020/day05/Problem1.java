package com.studio3104.adventofcode2020.day05;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.stream.Stream;

public class Problem1 {
    private static int findPosition(String seat, int tail, int start, int end, char lower, char upper) {
        int head = 0;

        for (int i = start; i <= end; ++i) {
            char p = seat.charAt(i);
            int n = head + (tail - head) / 2;
            if (p == lower) {
                tail = n;
            } else if (p == upper) {
                head = n + 1;
            } else {
                throw new RuntimeException();
            }
        }

        return head;
    }

    static int[] findPosition(String seat) {
        return new int[]{
                findPosition(seat, 127, 0, 6, 'F', 'B'),
                findPosition(seat, 7, 7, 9, 'L', 'R')
        };
    }

    private static int getResult(Stream<String> seats) {
        return seats
                .map(Problem1::findPosition)
                .mapToInt(p -> p[0] * 8 + p[1])
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadInput(5)));
    }
}
