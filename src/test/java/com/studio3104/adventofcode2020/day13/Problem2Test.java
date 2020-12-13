package com.studio3104.adventofcode2020.day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem2Test {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of("7,13,x,x,59,x,31,19", 1068781),
                Arguments.of("17,x,13,19", 3417),
                Arguments.of("67,7,59,61", 754018),
                Arguments.of("67,x,7,59,61", 779210),
                Arguments.of("67,7,x,59,61", 1261476),
                Arguments.of("1789,37,47,1889", 1202161486)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(String input, long expected) {
        Assertions.assertEquals(expected, Problem2.getResult(input));
    }
}
