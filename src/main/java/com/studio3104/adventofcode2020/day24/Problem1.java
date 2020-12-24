package com.studio3104.adventofcode2020.day24;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class Problem1 {
    private static void optimizeSteps(Map<String, Integer> steps, String d1, String d2, String t) {
        int n = Math.min(steps.get(d1), steps.get(d2));
        steps.put(t, steps.get(t) + n);
        steps.put(d1, steps.get(d1) - n);
        steps.put(d2, steps.get(d2) - n);
    }

    private static void optimizeSteps(Map<String, Integer> steps, String o1, String o2) {
        int n = Math.min(steps.get(o1), steps.get(o2));
        steps.put(o1, steps.get(o1) - n);
        steps.put(o2, steps.get(o2) - n);
    }

    private static void optimizeSteps(Map<String, Integer> steps) {
        optimizeSteps(steps, "nw", "sw", "w");
        optimizeSteps(steps, "ne", "se", "e");
        optimizeSteps(steps, "w", "ne", "nw");
        optimizeSteps(steps, "w", "se", "sw");
        optimizeSteps(steps, "e", "nw", "ne");
        optimizeSteps(steps, "e", "sw", "se");

        optimizeSteps(steps, "w", "e");
        optimizeSteps(steps, "nw", "se");
        optimizeSteps(steps, "sw", "ne");
    }

    private static void flipTile(Set<Map<String, Integer>> blackTiles, Map<String, Integer> steps) {
        if (blackTiles.contains(steps)) {
            blackTiles.remove(steps);
        } else {
            blackTiles.add(steps);
        }
    }

    static int getResult(String[] input) {
        Set<Map<String, Integer>> blackTiles = new HashSet<>();

        for (String route : input) {
            Map<String, Integer> steps = List.of("e", "w", "ne", "se", "nw", "sw")
                    .stream()
                    .collect(Collectors.toMap(s -> s, s -> 0));

            for (int i = 0; i < route.length(); ++i) {
                String d = String.valueOf(route.charAt(i));;

                if (d.equals("n") || d.equals("s")) {
                    d += route.charAt(++i);
                }

                steps.put(d, steps.get(d) + 1);
            }

            // Like `sync; sync; sync` haha...
            optimizeSteps(steps);
            optimizeSteps(steps);
            optimizeSteps(steps);

            flipTile(blackTiles, steps);
        }

        return blackTiles.size();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(24)));
    }
}
