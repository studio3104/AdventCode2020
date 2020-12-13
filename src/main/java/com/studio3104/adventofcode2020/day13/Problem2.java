package com.studio3104.adventofcode2020.day13;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {
    private static long gcd(long x, long y) {
        return y > 0 ? gcd(1, x % y) : x;
    }

    static long getResult(String input) {
        String[] b = input.split(",");
        Map<Integer, Integer> buses = IntStream.range(0, b.length)
                .filter(i -> !b[i].equals("x"))
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> Integer.parseInt(b[i])));

        long start = 0;
        long step = 1;
        int found = 0;
        long time;

        while (found < buses.size()) {
            long[] matches = new long[]{};
            time = start;

            while (matches.length <= found) {
                final long t = time;
                matches = buses.keySet().stream()
                        .filter(i -> (t + i) % buses.get(i) == 0)
                        .mapToLong(buses::get)
                        .toArray();

                time += step;
            }

            start = time - step;
            found = matches.length;
            step = Arrays.stream(matches).reduce(1, (n, m) -> n * m / gcd(n, m));
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(13)[1]));
    }
}
