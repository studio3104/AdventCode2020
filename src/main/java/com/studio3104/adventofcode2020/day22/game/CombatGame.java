package com.studio3104.adventofcode2020.day22.game;

@lombok.RequiredArgsConstructor
public class CombatGame implements Game {
    final Deck player1;
    final Deck player2;

    @lombok.Getter
    private boolean isOver = false;

    @lombok.Getter
    private int score = 0;

    @lombok.Getter
    private Deck winner;

    void finalizeGame(Deck winner) {
        this.winner = winner;
        isOver = true;
        score = winner.calculateScore();
    }

    void finalizeGameIfPossible() {
        if (isOver) {
            throw new RuntimeException("The game has been over");
        }

        if (player1.isEmpty() || player2.isEmpty()) {
            finalizeGame(player1.isEmpty() ? player2 : player1);
            return;
        }

        if (player1.canBeInfinity()) {
            finalizeGame(player1);
        }
    }

    @Override
    public void play() {
        finalizeGameIfPossible();
        if (isOver) return;

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
