package com.studio3104.adventofcode2020.day12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {
    @Test
    void getResult() {
        Assertions.assertEquals(286, Problem2.getResult(new String[]{
                "F10",
                "N3",
                "F7",
                "R90",
                "F11",
        }));
    }
}
