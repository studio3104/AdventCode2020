package com.studio3104.adventofcode2020.day21;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1 {
    private static void parseInt(String[] input, Map<String, Set<String>> candidatesOf, Map<String, Integer> countIngredientsOf) {
        Map<String, Map<String, Integer>> countIngredientsPerAllergenOf = new HashMap<>();
        Map<String, Integer> countAllergensOf = new HashMap<>();

        for (String line : input) {
            String[] s = line.split(" \\(contains ");
            String[] ingredients = s[0].split(" ");
            String[] allergens = s[1].substring(0, s[1].length() - 1).split(", ");

            for (String ingredient : ingredients) {
                countIngredientsOf.put(ingredient, countIngredientsOf.getOrDefault(ingredient, 0) + 1);
            }

            for (String allergen : allergens) {
                countAllergensOf.put(allergen, countAllergensOf.getOrDefault(allergen, 0) + 1);

                for (String ingredient : ingredients) {
                    countIngredientsPerAllergenOf.putIfAbsent(allergen, new HashMap<>());
                    Map<String, Integer> counter = countIngredientsPerAllergenOf.get(allergen);
                    counter.put(ingredient, counter.getOrDefault(ingredient, 0) + 1);
                }
            }
        }

        for (String allergen : countAllergensOf.keySet()) {
            int numAppearance = countAllergensOf.get(allergen);
            candidatesOf.putIfAbsent(allergen, new HashSet<>());

            for (Map.Entry<String, Integer> countOf : countIngredientsPerAllergenOf.get(allergen).entrySet()) {
                String ingredient = countOf.getKey();
                int count = countOf.getValue();
                if (numAppearance != count) continue;
                candidatesOf.get(allergen).add(ingredient);
            }
        }
    }

    static int getResult(String[] input) {
        Map<String, Set<String>> candidatesOf = new HashMap<>();
        Map<String, Integer> countIngredientsOf = new HashMap<>();
        parseInt(input, candidatesOf, countIngredientsOf);

        Map<String, String> identified = new HashMap<>();
        while (identified.size() != candidatesOf.size()) {
            for (String allergen : candidatesOf.keySet()) {
                Set<String> candidates = candidatesOf.get(allergen);
                candidates.removeAll(identified.keySet());
                if (candidates.size() != 1) continue;

                for (String ingredient : candidates) {
                    identified.put(ingredient, allergen);
                }
            }
        }

        int count = 0;
        for (String ingredient : countIngredientsOf.keySet()) {
            if (identified.containsKey(ingredient)) continue;
            count += countIngredientsOf.get(ingredient);
        }

        // for Part 2
        Map<String, String> reversedIdentified = new HashMap<>();
        for (String ingredient : identified.keySet()) {
            String allergen = identified.get(ingredient);
            reversedIdentified.put(allergen, ingredient);
        }
        StringBuilder sb = new StringBuilder();
        for (String allergen : reversedIdentified.keySet().stream().sorted().toArray(String[]::new)) {
            sb.append(reversedIdentified.get(allergen));
            sb.append(",");
        }
        System.out.println(sb.toString());


        // Part 1 result
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(21)));
    }
}
