package com.studio3104.adventofcode2020.day22;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem1Test {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{
                                "Player 1:",
                                "9",
                                "2",
                                "6",
                                "3",
                                "1",
                                "",
                                "Player 2:",
                                "5",
                                "8",
                                "4",
                                "7",
                                "10",
                        },
                        306
                )
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(String[] input, int expected) {
        int actual = Problem1.getResult(input);
        Assertions.assertEquals(expected, actual);
    }
}
