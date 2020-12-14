package com.studio3104.adventofcode2020.day14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {
    @Test
    void getResult() {
        long actual = Problem1.getResult(new String[]{
                "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0",
        });
        Assertions.assertEquals(165, actual);
    }
}
