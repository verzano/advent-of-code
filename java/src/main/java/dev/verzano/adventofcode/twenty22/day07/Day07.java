package dev.verzano.adventofcode.twenty22.day07;

import java.util.List;

class Day07 {
    protected static int part1(List<String> commands) {
        var workingDir = buildFileSystem(commands, File.root());
        File.root().prettyPrint(workingDir);
        return File.root().sizeOfSmallDirectories(100000);
    }

    protected static int part2(List<String> commands) {
        var workingDir = buildFileSystem(commands, File.root());
        File.root().prettyPrint(workingDir);
        return File.root().smallestDirectoryToFreeSpace(70000000, 30000000);
    }

    private static File buildFileSystem(List<String> commands, File root) {
        var workingDir = root;
        for (var commandPosition = 0; commandPosition < commands.size(); commandPosition++) {
            var command = commands.get(commandPosition);
            var parts = command.split(" ");

            switch (parts[1]) {
                case "cd" -> workingDir = workingDir.navigate(parts[2]);
                case "ls" -> commandPosition = processLs(commands, workingDir, commandPosition + 1);
                default ->
                        throw new RuntimeException("Line #" + (commandPosition + 1) + ", unknown command: " + parts[1]);
            }
        }
        return workingDir;
    }

    private static int processLs(List<String> commands, File workingDir, int commandPosition) {
        if (commandPosition >= commands.size()) {
            return commandPosition;
        }

        var parts = commands.get(commandPosition).split(" ");
        switch (parts[0]) {
            case "$" -> {
                return commandPosition - 1;
            }
            case "dir" -> {
                workingDir.addDirectory(parts[1]);
                return processLs(commands, workingDir, commandPosition + 1);
            }
            default -> {
                workingDir.addFile(parts[1], Integer.parseInt(parts[0]));
                return processLs(commands, workingDir, commandPosition + 1);
            }
        }
    }
}
