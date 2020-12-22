package com.studio3104.adventofcode2020.day22;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Deck {
    private final Deque<Integer> deck;

    Deck(int[] cards) {
        deck = new ArrayDeque<>();
        Arrays.stream(cards).forEachOrdered(deck::add);
    }

    boolean isEmpty() {
        return deck.isEmpty();
    }

    Integer draw() {
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
