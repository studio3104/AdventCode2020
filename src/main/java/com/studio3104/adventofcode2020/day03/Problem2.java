package com.studio3104.adventofcode2020.day03;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.math.BigInteger;
import java.util.Arrays;

public class Problem2 {
    private static BigInteger getResult(String[] map) {
        int[][] ways = new int[][]{{1, 1}, {3, 1}, {5, 1}, {7, 1}, {1, 2}};
        return Arrays.stream(ways)
                .mapToInt(w -> Problem1.countTrees(map, w[0], w[1]))
                .mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(3)));
    }
}
