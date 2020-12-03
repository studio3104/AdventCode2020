package com.studio3104.adventofcode2020.day03;

import com.studio3104.adventofcode2020.utilities.InputLoader;

public class Problem1 {
    private static int countTrees(String[] map) {
        int numTrees = 0;
        int p = 0;
        int len = map[0].length();

        for (int i = 1; i < map.length; ++i) {
            p += 3;
            if (p >= len) {
                p -= len;
            }
            if (map[i].charAt(p) == '#') {
                ++numTrees;
            }
        }

        return numTrees;
    }

    private static int getResult(String[] map) {
        return countTrees(map);
    }

    public static void main(String[] args) {
         System.out.println(getResult(InputLoader.loadStringInput(3)));
    }
}
