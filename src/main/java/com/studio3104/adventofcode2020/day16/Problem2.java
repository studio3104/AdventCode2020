package com.studio3104.adventofcode2020.day16;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem2 {
    static long getResult(String[] input) {
        Ticket ticket = new Ticket(input);
        Map<String, int[][]> patterns = ticket.getPatterns();

        Map<String, Set<Integer>> candidates = patterns
                .keySet()
                .stream()
                .collect(Collectors.toMap(s -> s, s -> new HashSet<>()));

        for (String fieldName : patterns.keySet()) {
            for (int i = 0; i < ticket.getYours().length; ++i) {
                boolean isValid = true;

                for (int[] nearby : ticket.getValidNearby()) {
                    if (!ticket.isWithinRangeOf(fieldName, nearby[i])) {
                        isValid = false;
                        break;
                    }
                }

                if (isValid) {
                    candidates.get(fieldName).add(i);
                }
            }
        }

        Map<String, Integer> indexOf = new HashMap<>();
        Set<Integer> toClear = new HashSet<>();
        long[] yours = Arrays.stream(ticket.getYours()).sequential().mapToLong(n -> n).toArray();

        while (toClear.size() < yours.length) {
            for (String name : candidates.keySet()) {
                Set<Integer> c = candidates.get(name);
                c.removeAll(toClear);
                if (c.size() != 1) {
                    continue;
                }

                c.forEach(n -> {
                    indexOf.put(name, n);
                    toClear.add(n);
                });
            }
        }

        int[] departureIndexes = indexOf
                .keySet()
                .stream()
                .filter(s -> s.startsWith("departure"))
                .mapToInt(indexOf::get)
                .toArray();

        return Arrays.stream(departureIndexes).mapToLong(i -> yours[i]).reduce((n, m) -> n * m).orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(16)));
    }
}
