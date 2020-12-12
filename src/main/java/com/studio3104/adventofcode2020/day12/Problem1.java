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

    private static int moveAndGetFacing(int facing, char direction, int amount, int[] position) {
        if (direction == 'L') {
            return (facing - amount / 90 + 4) % 4;
        }
        if (direction == 'R') {
            return (facing + amount / 90) % 4;
        }

        if (direction == 'F') {
            direction = directions[facing];
        }

        int[] offset = offsetOf.get(direction);
        position[0] += offset[0] * amount;
        position[1] += offset[1] * amount;

        return facing;
    }

    static int getResult(String[] instructions) {
        int facing = 0;
        int[] position = new int[]{0, 0};

        for (String i : instructions) {
            facing = moveAndGetFacing(facing, i.charAt(0), Integer.parseInt(i.substring(1)), position);
        }

        return Math.abs(position[0]) + Math.abs(position[1]);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(12)));
    }
}
