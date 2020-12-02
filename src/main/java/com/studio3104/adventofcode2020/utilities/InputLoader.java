package com.studio3104.adventofcode2020.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputLoader {
    private static Stream<String> readInputFile(Path path) {
        try {
            return Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Stream<String> loadInput(int day) {
        Path path = Paths.get("input", "day" + String.format("%02d", day) + ".txt");
        return readInputFile(path);
    }

    public static int[] loadIntegerInput(int day) {
        return loadInput(day).mapToInt(Integer::parseInt).toArray();
    }

    public static String[] loadStringInput(int day) {
        return (String[]) loadInput(day).toArray();
    }
}
