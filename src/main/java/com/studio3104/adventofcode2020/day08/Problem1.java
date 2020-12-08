package com.studio3104.adventofcode2020.day08;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    static int getResult(String[] stringCommands) {
        Command[] commands = Command.getCommands(stringCommands);

        int acc = 0;
        int p = 0;
        Set<Integer> done = new HashSet<>();

        while (!done.contains(p)) {
            done.add(p);

            Command c = commands[p];
            int n = c.getSign() == '+' ? c.getNum() : c.getNum() * -1;

            switch (c.getOperation()) {
                case "acc":
                    ++p;
                    acc += n;
                    break;
                case "jmp":
                    p += n;
                    break;
                case "nop":
                    ++p;
                    break;
                default:
                    throw new RuntimeException();
            }
        }

        return acc;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(8)));
    }
}
