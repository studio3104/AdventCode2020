package com.studio3104.adventofcode2020.day16;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Problem1 {
    private static void addPattern(String pattern, Map<String, int[][]> patterns) {
        String[] p = pattern.split(": ");
        int[][] ranges = Arrays.stream(p[1].split(" or "))
                .map(s -> {
                    String[] r = s.split("-");
                    return new int[]{Integer.parseInt(r[0]), Integer.parseInt(r[1])};
                })
                .toArray(int[][]::new);

        patterns.put(p[0], ranges);
    }

    private static int[][] mergePatterns(Map<String, int[][]> patterns) {
        List<int[]> ranges = new ArrayList<>();
        for (int[][] pattern : patterns.values()) {
            ranges.addAll(Arrays.asList(pattern));
        }
        ranges.sort(Comparator.comparingInt(o -> o[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(ranges.get(0));

        for (int i = 1; i < ranges.size(); ++i) {
            int[] currentRange = ranges.get(i);
            int[] lastRange = merged.get(merged.size() - 1);

            if (lastRange[1] >= currentRange[0]) {
                lastRange[1] = Math.max(lastRange[1], currentRange[1]);
                continue;
            }
            merged.add(currentRange);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    private static boolean isWithinRange(int n, int[][] patterns) {
        for (int[] p : patterns) {
            if (p[0] <= n && n <= p[1]) {
                return true;
            }
        }
        return false;
    }

    private static void validateTickets(int[][] tickets, int[][] patterns, List<Integer> invalids) {
        for (int[] ticket : tickets) {
            for (int n : ticket) {
                if (!isWithinRange(n, patterns)) {
                    invalids.add(n);
                }
            }
        }
    }

    static int getResult(String[] input) {
        Map<String, int[][]> patterns = new HashMap<>();
        int line = 0;

        // Parse valid range pattern
        for (; line < input.length; ++line) {
            String pattern = input[line];
            if (pattern.isBlank()) break;
            addPattern(pattern, patterns);
        }

        // Skip "your ticket"
        line += 5;

        // Parse nearby tickets
        int[][] nearbyTickets = IntStream.range(line, input.length)
                .mapToObj(n -> Arrays.stream(input[n].split(",")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);

        // Collect nums that are out of the ranges
        List<Integer> invalids = new ArrayList<>();
        validateTickets(nearbyTickets, mergePatterns(patterns), invalids);

        return invalids.stream().mapToInt(n -> n).sum();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(16)));
    }
}
