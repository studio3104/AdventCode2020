package com.studio3104.adventofcode2020.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem2Test {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 3, 6}, 175594),
                Arguments.of(new int[]{1, 3, 2}, 2578),
                Arguments.of(new int[]{2, 1, 3}, 3544142),
                Arguments.of(new int[]{1, 2, 3}, 261214),
                Arguments.of(new int[]{2, 3, 1}, 6895259),
                Arguments.of(new int[]{3, 2, 1}, 18),
                Arguments.of(new int[]{3, 1, 2}, 362)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(int[] nums, int expected) {
        int actual = Problem2.getResult(nums);
        Assertions.assertEquals(expected, actual);
    }
}
