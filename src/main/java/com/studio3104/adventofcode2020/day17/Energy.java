package com.studio3104.adventofcode2020.day17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Energy {
    private Map<Integer, boolean[][]> cubes;

    public Energy(String[] source) {
        cubes = new HashMap<>() {{
            put(0, Arrays.stream(source)
                    .map(s -> {
                        char[] c = s.toCharArray();
                        boolean[] b = new boolean[c.length];
                        for (int i = 0; i < c.length; ++i) {
                            b[i] = c[i] == '#';
                        }
                        return b;
                    })
                    .toArray(boolean[][]::new)
            );
        }};
    }

    public int countActives() {
        int count = 0;

        for (boolean[][] grid : cubes.values()) {
            for (boolean[] dimension : grid) {
                for (boolean cube : dimension) {
                    if (cube) {
                        ++count;
                    }
                }
            }
        }

        return count;
    }

    public void simulate() {
        Map<Integer, boolean[][]> nextCubes = new HashMap<>();

        for (int z : cubes.keySet()) {
            nextCubes.put(z, simulate(z));
        }

        // Extend `z` by one in both negative and positive directions.
        int next = cubes.size() / 2 + 1;
        nextCubes.put(next, simulate(next));
        nextCubes.put(next * -1, simulate(next * -1));

        cubes = nextCubes;
    }

    private boolean[][] simulate(int z) {
        // Expand next grid by two in both width and height.
        int yi = cubes.get(0).length + 2;
        int xi = cubes.get(0)[0].length + 2;
        boolean[][] grid = new boolean[yi][xi];

        for (int y = yi - 1; y >= 0; --y) {
            for (int x = xi - 1; x >= 0; --x) {
                boolean current = getActiveness(z, y - 1, x - 1);
                int n = countNeighborActives(x, y, z);
                if ((current && (n == 2 || n == 3)) || (!current && n == 3)) {
                    grid[y][x] = true;
                }
            }
        }

        return grid;
    }

    private int countNeighborActives(int xi, int yi, int zi) {
        int count = 0;

        for (int z = zi - 1; z <= zi + 1; ++z) {
            if (!cubes.containsKey(z)) {
                continue;
            }

            for (int y = yi - 1; y <= yi + 1; ++y) {
                for (int x = xi - 1; x <= xi + 1; ++x) {
                    if (z == zi && y == yi && x == xi) {
                        continue;
                    }

                    if (getActiveness(z, y - 1, x -1)) {
                        ++count;
                    }
                }
            }
        }

        return count;
    }

    private boolean getActiveness(int z, int y, int x) {
        if (!cubes.containsKey(z)) {
            return false;
        }
        boolean[][] g = cubes.get(z);

        if (y >= 0 && y < g.length && x >= 0 && x < g[0].length) {
            return g[y][x];
        }

        return false;
    }
}
