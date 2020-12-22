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

@lombok.RequiredArgsConstructor
class Game {
    private final Deck player1;
    private final Deck player2;

    @lombok.Getter
    private boolean isOver = false;

    @lombok.Getter
    private int score = 0;

    private void finalize(Deck winner) {
        isOver = true;
        score = winner.calculateScore();
    }

    public void play() {
        if (isOver) {
            throw new RuntimeException("The game has been over");
        }

        if (player1.isEmpty() || player2.isEmpty()) {
            finalize(player1.isEmpty() ? player2 : player1);
            return;
        }

        Integer card1 = player1.draw();
        Integer card2 = player2.draw();

        if (card1 > card2) {
            player1.put(card1);
            player1.put(card2);
        } else {
            player2.put(card2);
            player2.put(card1);
        }
    }
}
