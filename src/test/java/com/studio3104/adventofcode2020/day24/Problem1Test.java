package com.studio3104.adventofcode2020.day24;

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
                        },
                        10
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
