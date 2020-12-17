package com.studio3104.adventofcode2020.day16;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem2Test {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(0, "departure class: 0-1 or 4-19", 12),
                Arguments.of(1, "departure row: 0-5 or 8-19", 11),
                Arguments.of(2, "departure seat: 0-13 or 16-19", 13)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(int i, String s, int expected) {
        String[] input = new String[]{
                "class: 0-1 or 4-19",
                "row: 0-5 or 8-19",
                "seat: 0-13 or 16-19",
                "",
                "your ticket:",
                "11,12,13",
                "",
                "nearby tickets:",
                "3,9,18",
                "15,1,5",
                "5,14,9",
        };

        input[i] = s;
        long actual = Problem2.getResult(input);
        Assertions.assertEquals(expected, actual);
    }
}
