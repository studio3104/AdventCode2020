package com.studio3104.adventofcode2020.day20;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.Arrays;

public class Problem1 {
    private static void setTiles(int start, int end, String[] input, Tiles tiles) {
        int num = Integer.parseInt(input[start].substring(5, input[start].length() - 1));
        tiles.set(num, Arrays.copyOfRange(input, start + 1, end));
    }

    private static Tiles getTiles(String[] input) {
        Tiles tiles = new Tiles();

        int start = 0;
        for (int i = 0; i < input.length; ++i) {
            String s = input[i];
            if (s.startsWith("Tile")) {
                start = i;
            }
            if (s.isEmpty()) {
                setTiles(start, i, input, tiles);
            }
        }
        setTiles(start, input.length, input, tiles);

        return tiles;
    }

    static long getResult(String[] input) {
        long mul = 1L;
        Tiles tiles = getTiles(input);

        for (Tile tile : tiles.asMap().values()) {
            if (tile.isCornerOf(tiles)) {
                mul *= tile.number;
            }
        }

        return mul;
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(20)));
    }
}
