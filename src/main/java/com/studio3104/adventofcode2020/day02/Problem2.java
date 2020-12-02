package com.studio3104.adventofcode2020.day02;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.stream.Stream;

public class Problem2 {
    private static int getResult(Stream<Password> passwords) {
        return (int) passwords.filter(Password::isValid).count();
    }

    public static void main(String[] args) {
        Stream<Password> passwords = InputLoader.loadInput(2).map(PasswordWithRule2::new);
        System.out.println(Problem2.getResult(passwords));
    }
}
