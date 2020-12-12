package com.studio3104.adventofcode2020.day12;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    private final static char[] directions = new char[]{'E', 'S', 'W', 'N'};
    private final static Map<Character, int[]> offsetOf = new HashMap<>() {{
        put('E', new int[]{1, 0});
        put('S', new int[]{0, -1});
        put('W', new int[]{-1, 0});
        put('N', new int[]{0, 1});
    }};

    private static int rotate(int facing, char direction, int degrees) {
        if (direction == 'L') {
            return (facing - degrees / 90 + 4) % 4;
        }
        if (direction == 'R') {
            return (facing + degrees / 90) % 4;
        }
        return facing;
    }

    static int[] getOffset(char direction) {
        return offsetOf.get(direction);
    }

    static void move(int amount, int[] position, int[] offset) {
        position[0] += offset[0] * amount;
        position[1] += offset[1] * amount;
    }

    static int getResult(String[] instructions) {
        int facing = 0;
        int[] position = new int[]{0, 0};

        for (String i : instructions) {
            char direction = i.charAt(0);
            int amount = Integer.parseInt(i.substring(1));

            if (direction == 'L' || direction == 'R') {
                facing = rotate(facing, direction, amount);
                continue;
            }

            move(amount, position, getOffset(direction == 'F' ? directions[facing] : direction));
        }

        return Math.abs(position[0]) + Math.abs(position[1]);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(12)));
    }
}
