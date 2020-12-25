package com.studio3104.adventofcode2020.day24;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem2 {
    private static void updateRange(Set<List<Integer>> blackTiles, Map<String, Integer> range) {
        for (List<Integer> tile : blackTiles) {
            range.put("northernmost", Math.max(range.get("northernmost"), tile.get(0) + 1));
            range.put("southernmost", Math.min(range.get("southernmost"), tile.get(0) - 1));
            range.put("easternmost", Math.max(range.get("easternmost"), tile.get(1) + 2));
            range.put("westernmost", Math.min(range.get("westernmost"), tile.get(1) - 2));
        }
    }

    private static int countBlackAdjacentAround(List<Integer> tile, Set<List<Integer>> blackTiles) {
        int count = 0;

        int north = tile.get(0);
        int east = tile.get(1);

        if (blackTiles.contains(List.of(north, east + 2))) ++count;
        if (blackTiles.contains(List.of(north, east - 2))) ++count;
        if (blackTiles.contains(List.of(north + 1, east + 1))) ++count;
        if (blackTiles.contains(List.of(north + 1, east - 1))) ++count;
        if (blackTiles.contains(List.of(north - 1, east + 1))) ++count;
        if (blackTiles.contains(List.of(north - 1, east - 1))) ++count;

        return count;
    }

    private static void flipTiles(Set<List<Integer>> blackTiles, Map<String, Integer> range) {
        Set<List<Integer>> toWhite = new HashSet<>();
        Set<List<Integer>> toBlack = new HashSet<>();

        for (int north = range.get("southernmost"); north <= range.get("northernmost"); ++north) {
            for (int east = range.get("westernmost"); east <= range.get("easternmost"); ++east) {
                List<Integer> tile = List.of(north, east);
                int numBlack = countBlackAdjacentAround(tile, blackTiles);

                if (blackTiles.contains(tile)) {
                    if (numBlack == 0 || numBlack > 2) {
                        toWhite.add(tile);
                    }
                    continue;
                }

                if (numBlack == 2) {
                    toBlack.add(tile);
                }
            }
        }

        blackTiles.removeAll(toWhite);
        blackTiles.addAll(toBlack);
        updateRange(blackTiles, range);
    }

    static int getResult(String[] input, int days) {
        Set<List<Integer>> blackTiles = Problem1.identifyBlackTiles(input);

        Map<String, Integer> range = new HashMap<>();
        range.put("northernmost", Integer.MIN_VALUE);
        range.put("southernmost", Integer.MAX_VALUE);
        range.put("easternmost", Integer.MIN_VALUE);
        range.put("westernmost", Integer.MAX_VALUE);
        updateRange(blackTiles, range);

        for (int i = 0; i < days; ++i) {
            flipTiles(blackTiles, range);
        }

        return blackTiles.size();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(24), 100));
    }
}
