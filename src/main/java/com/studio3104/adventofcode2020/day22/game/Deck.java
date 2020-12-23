package com.studio3104.adventofcode2020.day22.game;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Deck {
    private final Deque<Integer> deck;
    private final Set<String> deckHistory;

    public Deck(int[] cards) {
        deck = new ArrayDeque<>();
        Arrays.stream(cards).forEachOrdered(deck::add);
        deckHistory = new HashSet<>();
    }

    Deck copy(int size) {
        Integer[] d = deck.toArray(Integer[]::new);
        return new Deck(
                Arrays.stream(d, 0, size)
                        .mapToInt(i -> i)
                        .toArray()
        );
    }

    boolean canBeInfinity() {
        return deckHistory.contains(deck.toString());
    }

    int getRemainingSize() {
        return deck.size();
    }

    boolean isEmpty() {
        return deck.isEmpty();
    }

    Integer draw() {
        deckHistory.add(deck.toString());
        return deck.pollFirst();
    }

    void put(int card) {
        deck.add(card);
    }

    int calculateScore() {
        int score = 0;
        int multipliedBy = 1;

        while (!deck.isEmpty()) {
            score += deck.pollLast() * multipliedBy++;
        }

        return score;
    }
}
