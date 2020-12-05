package com.studio3104.adventofcode2020.day05;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    private static int getResult(Stream<Seat> seats) {
        Set<Integer> seatIds = seats
                .filter(s -> s.getRow() != 0 && s.getRow() != 127)
                .mapToInt(Seat::getId)
                .boxed()
                .collect(Collectors.toSet());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int id : seatIds) {
            min = Math.min(min, id);
            max = Math.max(max, id);
        }

        for (int i = min; i <= max; ++i) {
            if (!seatIds.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadInput(5).map(Seat::new)));
    }
}
