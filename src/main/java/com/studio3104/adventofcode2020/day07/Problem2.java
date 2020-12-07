package com.studio3104.adventofcode2020.day07;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class Problem2 {
    static int getResult(String[] rules) {
        Map<String, Bag> bagOf = Bag.getBags(rules);
        Deque<InnerBag> q = new ArrayDeque<>();

        q.addLast(new InnerBag(bagOf.get("shiny gold"), 1));
        int numBags = 0;

        while (!q.isEmpty()) {
            InnerBag outer = q.pollFirst();
            numBags += outer.getAmount();

            for (InnerBag inner : outer.getBag().getInners()) {
                q.addLast(new InnerBag(inner.getBag(), outer.getAmount() * inner.getAmount()));
            }
        }

        return numBags - 1;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(7)));
    }
}
