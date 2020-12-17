package com.studio3104.adventofcode2020.day17;

import com.studio3104.adventofcode2020.utilities.InputLoader;

public class Problem1 {
    static int getResult(String[] input) {
        Energy energy = new Energy(input);
        for (int i = 0; i < 6; ++i) {
            energy.simulate();
        }
        return energy.countActives();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(17)));
    }
}
