package com.studio3104.adventofcode2020.day10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem1Test {
    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(new int[]{16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4}, 35),
                Arguments.of(new int[]{28, 33, 18, 42, 31, 14, 46, 20, 48, 47, 24, 23, 49, 45, 19, 38, 39, 11, 1, 32, 25, 35, 8, 17, 7, 9, 4, 2, 34, 10, 3}, 220)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(int[] nums, int expected) {
        int actual = Problem1.getResult(nums);
        Assertions.assertEquals(expected, actual);
    }
}
