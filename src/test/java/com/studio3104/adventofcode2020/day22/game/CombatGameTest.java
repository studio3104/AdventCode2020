package com.studio3104.adventofcode2020.day22.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CombatGameTest {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new Deck(new int[]{9, 2, 6, 3, 1}),
                        new Deck(new int[]{5, 8, 4, 7, 10}),
                        306
                )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void play(Deck player1, Deck player2, int expectedScore) {
        Game game = new CombatGame(player1, player2);
        while (!game.isOver()) game.play();
        Assertions.assertEquals(expectedScore, game.getScore());
    }
}
