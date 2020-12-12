package com.studio3104.adventofcode2020.day12;

import com.studio3104.adventofcode2020.utilities.InputLoader;

public class Problem2 {
    private static void rotate(char direction, int degrees, int[] waypoint) {
        degrees = direction == 'R' ? degrees : 360 - degrees;
        degrees %= 360;

        switch (degrees) {
            case 0:
                break;
            case 90:
                int x = waypoint[0];
                waypoint[0] = waypoint[1];
                waypoint[1] = x * -1;
                break;
            case 180:
                waypoint[0] *= -1;
                waypoint[1] *= -1;
                break;
            case 270:
                int y = waypoint[1];
                waypoint[1] = waypoint[0];
                waypoint[0] = y * -1;
                break;
        }
    }

    static int getResult(String[] instructions) {
        int[] waypoint = new int[]{10, 1};
        int[] ship = new int[]{0, 0};

        for (String i : instructions) {
            char action = i.charAt(0);
            int amount = Integer.parseInt(i.substring(1));

            if (action == 'F') {
                Problem1.move(amount, ship, waypoint);
                continue;
            }

            if (action == 'L' || action == 'R') {
                rotate(action, amount, waypoint);
                continue;
            }

            Problem1.move(amount, waypoint, Problem1.getOffset(action));
        }

        return Math.abs(ship[0]) + Math.abs(ship[1]);
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(12)));
    }
}
