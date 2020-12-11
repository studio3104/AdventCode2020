package com.studio3104.adventofcode2020.day11;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem2 {
    private static boolean canSeeOccupied(char[][] grid, int i, int j, int[] d) {
        i += d[0];
        j += d[1];

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
            return false;
        }

        char c = grid[i][j];

        if (c == '.') {
            return canSeeOccupied(grid, i, j, d);
        }

        return c == '#';
    }

    private static int countViewableOccupied(char[][] grid, int i, int j) {
        int[][] directions = new int[][]{{0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
        return (int) Arrays.stream(directions).filter(d -> canSeeOccupied(grid, i, j, d)).count();
    }

    private static char getCharAppliedRule(char[][] grid, int i, int j) {
        char s = grid[i][j];
        if (s == '.') return s;

        int numSurroundingsOccupied = countViewableOccupied(grid, i, j);

        if (s == 'L' && numSurroundingsOccupied == 0) {
            return '#';
        } else if (s == '#' && numSurroundingsOccupied >= 5) {
            return 'L';
        }

        return s;
    }

    private static void applyRule(char[][] grid) {
        char[][] nextGrid = new char[grid.length][grid[0].length];

        while (!Arrays.deepEquals(grid, nextGrid)) {
            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[i].length; ++j) {
                    nextGrid[i][j] = getCharAppliedRule(grid, i, j);
                }
            }

            char[][] temp = grid;
            grid = nextGrid;
            nextGrid = temp;
        }
    }

    static int getResult(char[][] grid) {
        applyRule(grid);
        int count = 0;
        for (char[] g : grid) {
            for (char c : g) {
                if (c == '#') ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadCharGrid(11)));
    }
}
