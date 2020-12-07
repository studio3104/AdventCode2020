package com.studio3104.adventofcode2020.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@lombok.Getter
public class Bag {
    private final String color;
    private final Set<Bag> outers;
    private final List<InnerBag> inners;

    public Bag(String color) {
        this.color = color;
        outers = new HashSet<>();
        inners = new ArrayList<>();
    }

    public static Map<String, Bag> getBags(String[] rules) {
        Map<String, Bag> bagOf = new HashMap<>();

        for (String rule : rules) {
            String[] r = rule.split(" bags contain ");

            Bag bag = bagOf.getOrDefault(r[0], new Bag(r[0]));
            bagOf.putIfAbsent(r[0], bag);

            if (r[1].equals("no other bags.")) {
                continue;
            }

            for (String content : r[1].split(", ")) {
                String[] c = content.split(" ");
                int amount = Integer.parseInt(c[0]);
                String color = String.join(" ", Arrays.copyOfRange(c, 1, c.length - 1));

                Bag sub = bagOf.getOrDefault(color, new Bag(color));
                bagOf.putIfAbsent(color, sub);

                sub.outers.add(bag);
                bag.inners.add(new InnerBag(sub, amount));
            }
        }

        return bagOf;
    }
}
