package com.studio3104.adventofcode2020.day15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem1Test {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 3, 6}, 436),
                Arguments.of(new int[]{1, 3, 2}, 1),
                Arguments.of(new int[]{2, 1, 3}, 10),
                Arguments.of(new int[]{1, 2, 3}, 27),
                Arguments.of(new int[]{2, 3, 1}, 78),
                Arguments.of(new int[]{3, 2, 1}, 438),
                Arguments.of(new int[]{3, 1, 2}, 1836)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(int[] nums, int expected) {
        int actual = Problem1.getResult(nums);
        Assertions.assertEquals(expected, actual);
    }
}
