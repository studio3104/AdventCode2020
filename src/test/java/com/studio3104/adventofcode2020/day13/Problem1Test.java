package com.studio3104.adventofcode2020.day13;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem1Test {
    @Test
    void getResult() {
        Assertions.assertEquals(295, Problem1.getResult(new String[]{
                "939",
                "7,13,x,x,59,x,31,19",
        }));
    }
}
