package com.studio3104.adventofcode2020.day03;

import com.studio3104.adventofcode2020.utilities.InputLoader;

public class Problem1 {
    public static int countTrees(String[] map, int toRight, int toDown) {
        int numTrees = 0;
        int p = 0;

        for (int i = toDown; i < map.length; i += toDown) {
            p += toRight;
            p %= map[0].length();

            if (map[i].charAt(p) == '#') {
                ++numTrees;
            }
        }

        return numTrees;
    }

    private static int getResult(String[] map) {
        return countTrees(map, 3, 1);
    }

    public static void main(String[] args) {
         System.out.println(getResult(InputLoader.loadStringInput(3)));
    }
}
