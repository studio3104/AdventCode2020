package com.studio3104.adventofcode2020.day06;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    private static int countAllYes(Map<Character, Integer> s, int n) {
        return (int) s.entrySet().stream().filter(e -> e.getValue() == n).count();
    }

    private static int getResult(String[] answers) {
        int sum = 0;
        int numInGroup = 0;
        Map<Character, Integer> s = new HashMap<>();

        for (String a : answers) {
            if (a.isBlank()) {
                sum += countAllYes(s, numInGroup);
                numInGroup = 0;
                s.clear();
                continue;
            }

            ++numInGroup;

            for (char c : a.toCharArray()) {
                s.put(c, s.getOrDefault(c, 0) + 1);
            }
        }

        return sum + countAllYes(s, numInGroup);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(6)));
    }
}
