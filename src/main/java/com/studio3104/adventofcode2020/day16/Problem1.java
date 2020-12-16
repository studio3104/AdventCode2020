package com.studio3104.adventofcode2020.day16;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    private static void validateTickets(Ticket ticket, List<Integer> invalids) {
        for (int[] t : ticket.getNearby()) {
            for (int n : t) {
                if (ticket.isWithinAnyRange(n)) {
                    invalids.add(n);
                }
            }
        }
    }

    static int getResult(String[] input) {
        Ticket ticket = new Ticket(input);

        List<Integer> invalids = new ArrayList<>();
        validateTickets(ticket, invalids);

        return invalids.stream().mapToInt(n -> n).sum();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(16)));
    }
}
