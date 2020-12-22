package com.studio3104.adventofcode2020.day22;

import com.studio3104.adventofcode2020.utilities.InputLoader;

import java.util.stream.IntStream;

public class Problem1 {
    static int getResult(String[] input) {
        int s = input.length / 2;
        Deck p1 = new Deck(IntStream.range(1, s).map(i -> Integer.parseInt(input[i])).toArray());
        Deck p2 = new Deck(IntStream.range(s + 2, input.length).map(i -> Integer.parseInt(input[i])).toArray());
        Game game = new Game(p1, p2);

        while (!game.isOver()) {
            game.play();
        }

        return game.getScore();
    }

    public static void main(String[] args) {
        System.out.println(getResult(InputLoader.loadStringInput(22)));
    }
}
