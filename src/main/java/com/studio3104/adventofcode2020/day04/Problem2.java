package com.studio3104.adventofcode2020.day04;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.List;

public class Problem2 {
    private static long getResult(List<Passport> passports) {
        return passports.stream().filter(p -> p.validate(true)).count();
    }

    public static void main(String[] args) {
        List<Passport> passports = Passport.getPassports(InputLoader.loadStringInput(4));
        System.out.println(getResult(passports));
    }
}
