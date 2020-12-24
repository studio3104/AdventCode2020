package com.studio3104.adventofcode2020.day24;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Problem1 {
    static int getResult(String[] input) {
        Set<List<Integer>> blackTiles = new HashSet<>();

        for (String steps : input) {
            int north = 0;
            int east = 0;

            for (int i = 0; i < steps.length(); ++i) {
                char d = steps.charAt(i);

                if (d == 'e' || d == 'w') {
                    east = d == 'e' ? east + 2 : east - 2;
                    continue;
                }

                north = d == 'n' ? north + 1 : north - 1;
                east = steps.charAt(++i) == 'e' ? east + 1 : east - 1;
            }

            List<Integer> tile = List.of(north, east);

            if (blackTiles.contains(tile)) {
                blackTiles.remove(tile);
            } else {
                blackTiles.add(tile);
            }
        }

        return blackTiles.size();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(24)));
    }
}
