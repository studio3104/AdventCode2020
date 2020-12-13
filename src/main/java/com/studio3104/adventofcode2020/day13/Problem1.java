package com.studio3104.adventofcode2020.day13;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem1 {
    static int getResult(String[] input) {
        int[] buses = Arrays.stream(input[1].split(","))
                .filter(s -> !s.equals("x"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int departAfter = Integer.parseInt(input[0]);
        int minWait = Integer.MAX_VALUE;
        int result = 0;

        for (int bus : buses) {
            int wait = departAfter % bus == 0 ? 0 : Math.abs(departAfter % bus - bus);
            if (wait < minWait) {
                minWait = wait;
                result = wait * bus;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(13)));
    }
}
