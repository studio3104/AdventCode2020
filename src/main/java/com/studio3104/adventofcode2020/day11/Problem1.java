package com.studio3104.adventofcode2020.day11;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem1 {
    private static int countAdjacentOccupied(char[][] grid, int i, int j) {
        int count = 0;

        for (int k = i - 1; k <= i + 1; ++k) {
            if (k < 0 || k >= grid.length) continue;

            for (int l = j - 1; l <= j + 1; ++l) {
                if (k == i && l == j) continue;

                if (l >= 0 && l < grid[k].length && grid[k][l] == '#') {
                    ++count;
                }
            }
        }

        return count;
    }

    private static char getCharAppliedRule(char[][] grid, int i, int j) {
        char s = grid[i][j];
        if (s == '.') return s;

        int numAdjacentOccupied = countAdjacentOccupied(grid, i, j);

        if (s == 'L' && numAdjacentOccupied == 0) {
            return '#';
        } else if (s == '#' && numAdjacentOccupied >= 4) {
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
        System.out.println(getResult(InputLoader.loadGrid(11)));
    }
}
