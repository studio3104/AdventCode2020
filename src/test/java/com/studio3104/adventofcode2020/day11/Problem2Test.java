package com.studio3104.adventofcode2020.day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {
    @Test
    void getResult() {
        Assertions.assertEquals(26, Problem2.getResult(new char[][]{
                "L.LL.LL.LL".toCharArray(),
                "LLLLLLL.LL".toCharArray(),
                "L.L.L..L..".toCharArray(),
                "LLLL.LL.LL".toCharArray(),
                "L.LL.LL.LL".toCharArray(),
                "L.LLLLL.LL".toCharArray(),
                "..L.L.....".toCharArray(),
                "LLLLLLLLLL".toCharArray(),
                "L.LLLLLL.L".toCharArray(),
                "L.LLLLL.LL".toCharArray(),
        }));
    }
}