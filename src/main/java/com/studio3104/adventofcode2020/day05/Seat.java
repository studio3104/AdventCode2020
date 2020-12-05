package com.studio3104.adventofcode2020.day05;

@lombok.Getter
public class Seat {
    private final int row;
    private final int col;
    private final int id;

    public static int calculateId(int row, int col) {
        return row * 8 + col;
    }

    public Seat(String seat) {
        int[] p = findPosition(seat);
        row = p[0];
        col = p[1];
        id = calculateId(row, col);
    }

    private int findPosition(String seat, int tail, int start, int end, char lower, char upper) {
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

    private int[] findPosition(String seat) {
        return new int[]{
                findPosition(seat, 127, 0, 6, 'F', 'B'),
                findPosition(seat, 7, 7, 9, 'L', 'R')
        };
    }
}
