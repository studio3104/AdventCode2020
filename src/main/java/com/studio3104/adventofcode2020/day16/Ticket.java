package com.studio3104.adventofcode2020.day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@lombok.Getter
public class Ticket {
    private final Map<String, int[][]> patterns;
    private final int[][] mergedPatterns;
    private final int[] yours;
    private final int[][] nearby;

    public Ticket(String[] stringInput) {
        patterns = new HashMap<>();
        int line = parsePatternsAndGetNextLine(stringInput);
        mergedPatterns = mergePatterns();

        yours = parseTicket(line + 1, stringInput);
        nearby = parseNearbyTickets(line + 4, stringInput);
    }

    public boolean isWithinAnyRange(int n) {
        for (int[] p : mergedPatterns) {
            if (p[0] <= n && n <= p[1]) {
                return true;
            }
        }
        return false;
    }

    private void addPattern(String pattern) {
        String[] p = pattern.split(": ");

        int[][] ranges = Arrays.stream(p[1].split(" or "))
                .map(s -> {
                    String[] r = s.split("-");
                    return new int[]{Integer.parseInt(r[0]), Integer.parseInt(r[1])};
                })
                .toArray(int[][]::new);

        patterns.put(p[0], ranges);
    }

    private int parsePatternsAndGetNextLine(String[] input) {
        int line = 0;

        for (; line < input.length; ++line) {
            String pattern = input[line];
            if (pattern.isBlank()) break;
            addPattern(pattern);
        }

        return line + 1;
    }

    private int[] parseTicket(int line, String[] input) {
        return Arrays.stream(input[line].split(",")).mapToInt(Integer::parseInt).toArray();
    }

    private int[][] parseNearbyTickets(int line, String[] input) {
        return IntStream.range(line, input.length)
                .mapToObj(n -> parseTicket(n, input))
                .toArray(int[][]::new);
    }

    private int[][] mergePatterns() {
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
}
