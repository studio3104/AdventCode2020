package com.studio3104.adventofcode2020.day22.game;

import java.util.HashSet;
import java.util.Set;

public interface Game {
    boolean isOver();

    int getScore();

    Deck getWinner();

    void play();
}

@lombok.RequiredArgsConstructor
class CombatGameBase implements Game {
    private final Deck player1;
    private final Deck player2;
    private final boolean recursive;

    private final Set<String> history = new HashSet<>();

    @lombok.Getter
    private boolean isOver = false;

    @lombok.Getter
    private int score = 0;

    @lombok.Getter
    private Deck winner;

    private void finalizeGame(Deck winner) {
        this.winner = winner;
        isOver = true;
        score = winner.calculateScore();
    }

    private Deck playSubGame(Integer card1, Integer card2) {
        Deck subPlayer1 = player1.copy(card1);
        Deck subPlayer2 = player2.copy(card2);
        Game subGame = new RecursiveCombatGame(subPlayer1, subPlayer2);

        while (!subGame.isOver()) {
            subGame.play();
        }

        return subGame.getWinner() == subPlayer1 ? player1 : player2;
    }

    @Override
    public void play() {
        if (isOver) {
            throw new RuntimeException("The game has been over");
        }

        if (player1.isEmpty() || player2.isEmpty()) {
            finalizeGame(player1.isEmpty() ? player2 : player1);
            return;
        }

        String currentCards = player1.dump() + ":" + player2.dump();

        if (history.contains(currentCards)) {
            finalizeGame(player1);
            return;
        }

        history.add(currentCards);

        Integer card1 = player1.draw();
        Integer card2 = player2.draw();

        Deck winner = card1 > card2 ? player1 : player2;

        if (recursive && card1 <= player1.getRemainingSize() && card2 <= player2.getRemainingSize()) {
            winner = playSubGame(card1, card2);
        }

        if (winner == player1) {
            winner.put(card1);
            winner.put(card2);
        } else {
            winner.put(card2);
            winner.put(card1);
        }
    }
}
