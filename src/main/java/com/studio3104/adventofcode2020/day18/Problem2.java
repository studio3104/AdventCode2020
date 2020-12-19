package com.studio3104.adventofcode2020.day18;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;
import java.util.Set;

public class Problem2 {
    static long getResult(String[] formulas) {
        Calculator calculator = new Calculator(Set.of('+'));
        return Arrays.stream(formulas).mapToLong(calculator::calculate).sum();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(18)));
    }
}
