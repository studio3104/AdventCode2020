package com.studio3104.adventofcode2020.day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Problem2Test {
    @Test
    void getResult() {
        Assertions.assertEquals(8, Problem2.getResult(new String[]{
                "nop +0",
                "acc +1",
                "jmp +4",
                "acc +3",
                "jmp -3",
                "acc -99",
                "acc +1",
                "jmp -4",
                "acc +6",
        }));
    }
}
