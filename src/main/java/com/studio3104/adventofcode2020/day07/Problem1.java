package com.studio3104.adventofcode2020.day07;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.*;

public class Problem1 {
    private static int getResult(String[] rules) {
        Map<String, Bag> bagOf = Bag.getBags(rules);

        Deque<Bag> q = new ArrayDeque<>();
        q.addLast(bagOf.get("shiny gold"));

        Set<Bag> includes = new HashSet<>();

        while (!q.isEmpty()) {
            Bag bag = q.pollFirst();

            if (includes.contains(bag)) {
                continue;
            }
            includes.add(bag);

            for (Bag outer : bag.getOuters()) {
                q.addLast(outer);
            }
        }

        return includes.size() - 1;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(7)));
    }
}
