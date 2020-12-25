package com.studio3104.adventofcode2020.day24;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Problem2Test {
    static final String[] steps = new String[]{
            "sesenwnenenewseeswwswswwnenewsewsw",
            "neeenesenwnwwswnenewnwwsewnenwseswesw",
            "seswneswswsenwwnwse",
            "nwnwneseeswswnenewneswwnewseswneseene",
            "swweswneswnenwsewnwneneseenw",
            "eesenwseswswnenwswnwnwsewwnwsene",
            "sewnenenenesenwsewnenwwwse",
            "wenwwweseeeweswwwnwwe",
            "wsweesenenewnwwnwsenewsenwwsesesenwne",
            "neeswseenwwswnwswswnw",
            "nenwswwsewswnenenewsenwsenwnesesenew",
            "enewnwewneswsewnwswenweswnenwsenwsw",
            "sweneswneswneneenwnewenewwneswswnese",
            "swwesenesewenwneswnwwneseswwne",
            "enesenwswwswneneswsenwnewswseenwsese",
            "wnwnesenesenenwwnenwsewesewsesesew",
            "nenewswnwewswnenesenwnesewesw",
            "eneswnwswnwsenenwnwnwwseeswneewsenese",
            "neswnwewnwnwseenwseesewsenwsweewe",
            "wseweeenwnesenwwwswnew",
    };

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                Arguments.of(1, 15),
                Arguments.of(2, 12),
                Arguments.of(3, 25),
                Arguments.of(4, 14),
                Arguments.of(5, 23),
                Arguments.of(6, 28),
                Arguments.of(7, 41),
                Arguments.of(8, 37),
                Arguments.of(9, 49),
                Arguments.of(10, 37),
                Arguments.of(20, 132),
                Arguments.of(30, 259),
                Arguments.of(40, 406),
                Arguments.of(50, 566),
                Arguments.of(60, 788),
                Arguments.of(70, 1106),
                Arguments.of(80, 1373),
                Arguments.of(90, 1844),
                Arguments.of(100, 2208)
        );
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    void getResult(int days, int expected) {
        int actual = Problem2.getResult(steps, days);
        Assertions.assertEquals(expected, actual);
    }
}
