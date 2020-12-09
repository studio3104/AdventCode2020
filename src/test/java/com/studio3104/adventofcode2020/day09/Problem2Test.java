package com.studio3104.adventofcode2020.day09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {
    @Test
    void getResult() {
        Assertions.assertEquals(62, Problem2.getResult(
                new long[]{35, 20, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576,},
                5
        ));
    }
}