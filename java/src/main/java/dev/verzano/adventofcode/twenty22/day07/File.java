package dev.verzano.adventofcode.twenty22.day07;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

record File(
        String name,
        File parent,
        boolean isDir,
        AtomicInteger size,
        HashMap<String, File> children) {
    private static final File ROOT = new File("/", null, true, new AtomicInteger(0), new HashMap<>());
    private static final String SINGLE_INDENT = "  ";

    public static File root() {
        return ROOT;
    }

    public void addDirectory(String name) {
        children.put(name, new File(name, this, true, new AtomicInteger(0), new HashMap<>()));
    }

    public List<File> getDirectories() {
        var directories = new LinkedList<File>();
        children.values()
                .stream()
                .filter(File::isDir)
                .forEach(directories::add);
        return directories;
    }

    public void addFile(String name, int size) {
        children.put(name, new File(name, this, false, new AtomicInteger(size), new HashMap<>()));
        var dir = this;
        while (dir != null) {
            dir.size.addAndGet(size);
            dir = dir.parent;
        }
    }

    public File navigate(String destination) {
        if (destination.equals("..")) {
            return parent;
        } else if (destination.equals(ROOT.name)) {
            return ROOT;
        } else if (children.containsKey(destination)) {
            return children.get(destination);
        } else {
            throw new RuntimeException("Unknown child directory: " + destination + " in working directory: " + name);
        }
    }

    public void prettyPrint(File workingDir) {
        prettyPrintInternal("", workingDir, new HashSet<>());
    }

    private void prettyPrintInternal(String indentation, File workingDir, HashSet<String> alreadyVisited) {
        var prefix = indentation + (this == workingDir ? "+" : "-") + " " + name + " ";
        var suffix = "(" + (isDir ? "dir" : "file") + ", size=" + size + ")";
        System.out.println(prefix + suffix);
        if (alreadyVisited.add(name)) {
            children.values().stream()
                    .sorted(Comparator.comparing(c -> c.name))
                    .forEach(c -> c.prettyPrintInternal(indentation + SINGLE_INDENT, workingDir, alreadyVisited));
        }
    }

    public int sizeOfSmallDirectories(int maxDirectorySize) {
        var totalSize = size.get() <= maxDirectorySize ? size.get() : 0;
        totalSize += children.values().stream()
                .filter(c -> c.isDir)
                .mapToInt(d -> d.sizeOfSmallDirectories(maxDirectorySize))
                .sum();
        return totalSize;
    }

    @Override
    public String toString() {
        return "Directory[" +
                "name=" + name + ", " +
                "parent=" + parent + ", " +
                "children=" + children.keySet() + ']';
    }

    public int smallestDirectoryToFreeSpace(int totalFileSystemSize, int requiredSpace) {
        var additionalRequiredSpace = requiredSpace - (totalFileSystemSize - ROOT.size.get());
        var dirToDelete = ROOT;
        var dirs = ROOT.getDirectories();
        while (!dirs.isEmpty()) {
            var dir = dirs.remove(0);
            dirs.addAll(dir.getDirectories());

            if (dir.size.get() < dirToDelete.size.get() && dir.size.get() > additionalRequiredSpace) {
                dirToDelete = dir;
            }
        }

        return dirToDelete.size.get();
    }
}
