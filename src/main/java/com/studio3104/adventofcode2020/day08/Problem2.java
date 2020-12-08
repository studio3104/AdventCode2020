package com.studio3104.adventofcode2020.day08;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashSet;
import java.util.Set;

public class Problem2 {
     private static Integer execCommands(Command[] commands, int acc, int p, Set<Integer> done, boolean changed) {
        while (!done.contains(p) && p >= 0 && p < commands.length) {
            done.add(p);

            Command c = commands[p];
            int n = c.getSign() == '+' ? c.getNum() : c.getNum() * -1;
            Integer i;

            switch (c.getOperation()) {
                case "acc":
                    ++p;
                    acc += n;
                    break;
                case "jmp":
                    if (changed) {
                        p += n;
                        break;
                    }
                    i = execCommands(commands, acc, p + 1, new HashSet<>(done), true);
                    return i != null ? i : execCommands(commands, acc, p + n, done, false);
                case "nop":
                    if (changed) {
                        ++p;
                        break;
                    }
                    i = execCommands(commands, acc, p + n, new HashSet<>(done), true);
                    return i != null ? i : execCommands(commands, acc, p + 1, done, false);
                default:
                    throw new RuntimeException();
            }
        }

        return p == commands.length ? acc : null;
    }

    static int getResult(String[] stringCommands) {
        Command[] commands = Command.getCommands(stringCommands);
        Integer result = execCommands(commands, 0, 0, new HashSet<>(), false);
        if (result == null) throw new RuntimeException();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(8)));
    }
}
