package com.studio3104.adventofcode2020.day20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Tiles {
    private final Map<Integer, Tile> tiles = new HashMap<>();

    public boolean contains(int number) {
        return tiles.containsKey(number);
    }

    public Tile get(int number) {
        return tiles.get(number);
    }

    public void set(int number, String[] square) {
        if (contains(number)) throw new RuntimeException();
        tiles.put(number, new Tile(number, square));
    }

    public Map<Integer, Tile> asMap() {
        return tiles;
    }
}

class Tile {
    final int number;
    final String[] square;

    final Side upSide;
    final Side downSide;
    final Side leftSide;
    final Side rightSide;
    final Side[] sides;

    private String[] getSides() {
        String[] sides = new String[4];

        sides[0] = square[0];
        sides[2] = new StringBuilder(square[square.length - 1]).reverse().toString();

        StringBuilder leftSideBuilder = new StringBuilder();
        StringBuilder rightSideBuilder = new StringBuilder();
        for (String l : square) {
            leftSideBuilder.append(l.charAt(0));
            rightSideBuilder.append(l.charAt(l.length() - 1));
        }

        sides[1] = rightSideBuilder.toString();
        sides[3] = leftSideBuilder.reverse().toString();

        return sides;
    }

    public Tile(int number, String[] square) {
        this.number = number;
        this.square = square;

        String[] s = getSides();
        upSide = new Side(s[0]);
        downSide = new Side(s[2]);
        leftSide = new Side(s[3]);
        rightSide = new Side(s[1]);

        sides = new Side[]{upSide, rightSide, downSide, leftSide};
    }

    public int countSameSides(Tile another) {
        return (int) Arrays.stream(another.sides)
                .filter(s -> s.equals(upSide) || s.equals(downSide) || s.equals(leftSide) || s.equals(rightSide))
                .count();
    }

    public boolean isCornerOf(Tiles tiles) {
        int count = 0;

        for (int n : tiles.asMap().keySet()) {
            int numSameSides = tiles.get(n).countSameSides(tiles.get(number));
            if (numSameSides < 4) {
                count += numSameSides;
            }
        }

        return count == 2;
    }
}

class Side {
    private final String straight;
    private final String reversed;

    public boolean equals(Side another) {
        return straight.equals(another.straight) || straight.equals(another.reversed);
    }

    public Side(String straight) {
        this.straight = straight;
        reversed = new StringBuilder(straight).reverse().toString();
    }
}
