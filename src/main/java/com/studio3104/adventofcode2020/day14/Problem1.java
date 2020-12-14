package com.studio3104.adventofcode2020.day14;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    static long getResult(String[] input) {
        String mask = input[0].split(" = ")[1];
        Map<Integer, Long> memory = new HashMap<>();

        for (int i = 1; i < input.length; ++i) {
            String[] v = input[i].split(" = ");

            if (v[0].equals("mask")) {
                mask = v[1];
                continue;
            }

            int address = Integer.parseInt(v[0].substring(4, v[0].length() - 1));
            long value = Long.parseLong(v[1]);

            for (int j = mask.length() - 1; j >= 0; --j) {
                char b = mask.charAt(j);
                if (b == 'X') continue;

                long bit = 1L << Math.abs(j - mask.length()) - 1;
                if (b == '0') {
                    value &= ~bit;
                } else {
                    value |= bit;
                }
            }

            memory.put(address, value);
        }

        return memory.values().stream().mapToLong(n -> n).sum();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(14)));
    }
}
