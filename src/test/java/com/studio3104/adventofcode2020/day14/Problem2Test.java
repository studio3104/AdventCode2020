package com.studio3104.adventofcode2020.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {
    @Test
    void getResult() {
        long actual = Problem2.getResult(new String[]{
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100",
                "mask = 00000000000000000000000000000000X0XX",
                "mem[26] = 1",
        });
        Assertions.assertEquals(208, actual);
    }
}