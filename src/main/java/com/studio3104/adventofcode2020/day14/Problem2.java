package com.studio3104.adventofcode2020.day14;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.*;

public class Problem2 {
    private static void updateAddresses(char mask, long bit, long address, Set<Long> Addresses) {
        if (mask == 'X') {
            updateAddresses('0', bit, address, Addresses);
            updateAddresses('1', bit, address, Addresses);
            return;
        }

        Addresses.add(mask == '0' ? address & ~bit : address | bit);
    }

    static long getResult(String[] input) {
        String mask = input[0].split(" = ")[1];
        Map<Long, Long> memory = new HashMap<>();

        for (int i = 1; i < input.length; ++i) {
            String[] v = input[i].split(" = ");

            if (v[0].equals("mask")) {
                mask = v[1];
                continue;
            }

            int address = Integer.parseInt(v[0].substring(4, v[0].length() - 1));
            long value = Long.parseLong(v[1]);
            Set<Long> addresses = new HashSet<>();

            for (int j = mask.length() - 1; j >= 0; --j) {
                char b = mask.charAt(j);
                if (b == '0') continue;

                long bit = 1L << Math.abs(j - mask.length()) - 1;

                if (addresses.isEmpty()) {
                    updateAddresses(b, bit, address, addresses);
                    continue;
                }

                Set<Long> newAddresses = new HashSet<>();
                for (long val : addresses) {
                    updateAddresses(b, bit, val, newAddresses);
                }
                addresses = newAddresses;
            }

            for (long a : addresses) {
                memory.put(a, value);
            }
        }

        return memory.values().stream().mapToLong(n -> n).sum();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(14)));
    }
}
