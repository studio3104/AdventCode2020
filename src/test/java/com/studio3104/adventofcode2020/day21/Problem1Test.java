package com.studio3104.adventofcode2020.day21;

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
                                "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
                                "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                                "sqjhc fvjkl (contains soy)",
                                "sqjhc mxmxvkd sbzzf (contains fish)",
                        },
                        5
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
