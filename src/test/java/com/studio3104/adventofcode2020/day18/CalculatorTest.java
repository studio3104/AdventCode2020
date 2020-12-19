package com.studio3104.adventofcode2020.day18;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class CalculatorTest {
    static String[] formulas = new String[]{
            "1 + 2 * 3 + 4 * 5 + 6",
            "1 + (2 * 3) + (4 * (5 + 6))",
            "2 * 3 + (4 * 5)",
            "5 + (8 * 3 + 9 + 3 * 4 * 3)",
            "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))",
            "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2",
    };

    static Stream<Arguments> argumentsProvider() {
        int[] e1 = new int[]{  // + == *
                71,
                51,
                26,
                437,
                12240,
                13632,
        };

        int[] e2 = new int[]{  // + > *
                231,
                51,
                46,
                1445,
                669060,
                23340,
        };

        return Stream.concat(
                IntStream.range(0, e1.length)
                        .mapToObj(i -> Arguments.of(formulas[i], e1[i], Set.of('+', '*'))),
                IntStream.range(0, e2.length)
                        .mapToObj(i -> Arguments.of(formulas[i], e2[i], Set.of('+')))
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void calculate(String formula, long expected, Set<Character> precedences) {
        Calculator calculator = new Calculator(precedences);
        long actual = calculator.calculate(formula);
        Assertions.assertEquals(expected, actual);
    }
}
