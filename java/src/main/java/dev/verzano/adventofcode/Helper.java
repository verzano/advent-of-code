package dev.verzano.adventofcode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    private Helper() {

    }

    public static String getResourceAsString(String file) {
        try {
            return Files.readString(
                    Paths.get(Helper.class
                            .getClassLoader()
                            .getResource(file)
                            .toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get file: " + file, e);
        }
    }

    public static List<String> getResourceAsStringList(String file) {
        try {
            return Files.readAllLines(
                    Paths.get(Helper.class
                            .getClassLoader()
                            .getResource(file)
                            .toURI()));
        } catch (Exception e) {
            throw new RuntimeException("Failed to get file: " + file, e);
        }
    }

    public static List<Integer> getResourceAsIntegerList(String file) {
        return getResourceAsStringList(file)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static char[][] getResourceAsCharMatrix(String file) {
        return getResourceAsStringList(file)
                .stream()
                .map(String::toCharArray)
                .toList()
                .toArray(new char[][]{});
    }
}
