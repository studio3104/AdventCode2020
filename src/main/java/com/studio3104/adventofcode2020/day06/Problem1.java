package com.studio3104.adventofcode2020.day06;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    private static int getResult(String[] answers) {
        int sum = 0;
        Set<Character> s = new HashSet<>();

        for (String a : answers) {
            if (a.isBlank()) {
                sum += s.size();
                s.clear();
                continue;
            }

            for (char c : a.toCharArray()) {
                s.add(c);
            }
        }

        return sum + s.size();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(6)));
    }
}
