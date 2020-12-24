package com.studio3104.adventofcode2020.day24;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

enum Color {
    Black,
    White,
}

@Deprecated
public class Tile {
    private Color color = Color.White;

    private Tile west = null;
    private Tile east = null;
    private Tile northWest = null;
    private Tile northEast = null;
    private Tile southWest = null;
    private Tile southEast = null;

    private boolean isSet = false;

    private void flip() {
        color = color == Color.White ? Color.Black : Color.White;
    }

    public void flip(String steps) {
        Tile current = this;

        for (int i = 0; i < steps.length(); ++i) {
            current.set();
            char d = steps.charAt(i);

            if (d != 'n' && d != 's') {
                current = d == 'w' ? current.west : current.east;
                continue;
            }

            ++i;

            if (d == 'n') {
                current = steps.charAt(i) == 'w' ? current.northWest : current.northEast;
            } else {
                current = steps.charAt(i) == 'w' ? current.southWest : current.southEast;
            }
        }

        current.flip();
    }

    public int countBlack() {
        int count = 0;

        Set<Tile> visited = new HashSet<>();
        Deque<Tile> q = new ArrayDeque<>();
        q.add(this);

        while (!q.isEmpty()) {
            Tile t = q.poll();

            if (visited.contains(t)) {
                continue;
            }
            visited.add(t);

            if (t.color == Color.Black) {
                ++count;
            }

            if (t.west != null) q.add(t.west);
            if (t.east != null) q.add(t.east);
            if (t.northWest != null) q.add(t.northWest);
            if (t.northEast != null) q.add(t.northEast);
            if (t.southWest != null) q.add(t.southWest);
            if (t.southEast != null) q.add(t.southEast);
        }

        return count;
    }

    public void set() {
        if (isSet) return;

        if (west == null) west = new Tile();
        if (east == null) east = new Tile();
        if (northWest == null) northWest = new Tile();
        if (northEast == null) northEast = new Tile();
        if (southWest == null) southWest = new Tile();
        if (southEast == null) southEast = new Tile();

        west.northEast = northWest;
        west.southEast = southWest;
        west.east = this;

        east.northWest = northEast;
        east.southWest = southEast;
        east.west = this;

        northWest.southWest = west;
        northWest.east = northEast;
        northWest.southEast = this;

        northEast.southEast = east;
        northEast.west = northWest;
        northEast.southWest = this;

        southWest.northWest = west;
        southWest.east = southEast;
        southWest.northEast = this;

        southEast.northEast = east;
        southEast.west = southWest;
        southEast.northWest = this;

        isSet = true;
    }
}
