package com.studio3104.adventofcode2020.day05;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.stream.Stream;

public class Problem1 {
    private static int getResult(Stream<Seat> seats) {
        return seats
                .mapToInt(Seat::getId)
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadInput(5).map(Seat::new)));
    }
}
