package com.studio3104.adventofcode2020.day13;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem2 {
    static long getResult(String input) {
        int[] buses = Arrays.stream(input.split(","))
                .mapToInt(s -> s.equals("x") ? -1 : Integer.parseInt(s))
                .toArray();

        int maxId = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < buses.length; ++i) {
            int bus = buses[i];
            if (bus > maxId) {
                maxId = bus;
                maxIndex = i;
            }
        }

//        long result = Long.parseLong("100000000000000");
//        result -= result % buses[0];
        long result = maxId - maxIndex;

        while (true) {
            result += maxId;
            int i = 1;

            for (; i < buses.length; ++i) {
                int bus = buses[i];
                if (bus == -1 || i == maxIndex) continue;
                if (i != Math.abs(result % bus - bus)) break;
            }

            if (i == buses.length && result % buses[0] == 0) break;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(13)[1]));
    }
}
