package com.studio3104.adventofcode2020.day22.game;

public interface Game {
    boolean isOver();
    int getScore();
    Deck getWinner();
    void play();
}
