package com.studio3104.adventofcode2020.day22.game;

public class RecursiveCombatGame extends CombatGame {
    public RecursiveCombatGame(Deck player1, Deck player2) {
        super(player1, player2);
    }

    @Override
    public void play() {
        finalizeGameIfPossible();
        if (isOver()) return;

        Integer card1 = player1.draw();
        Integer card2 = player2.draw();

        Deck winner = card1 > card2 ? player1 : player2;

        if (card1 <= player1.getRemainingSize() && card2 <= player2.getRemainingSize()) {
            Deck subPlayer1 = player1.copy(card1);
            Deck subPlayer2 = player2.copy(card2);
            Game subGame = new RecursiveCombatGame(subPlayer1, subPlayer2);

            while (!subGame.isOver()) {
                subGame.play();
            }
            winner = subGame.getWinner() == subPlayer1 ? player1 : player2;
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
