package main

import (
	"aoc-2023/pkg/data"
	"aoc-2023/pkg/day01"
	"flag"
	"log/slog"
	"os"
)

func main() {
	day := flag.Int("day", 0, "Which day to check")
	part := flag.Int("part", 0, "Which part to check")
	flag.Parse()

	switch {
	case *day == 1 && *part == 1:
		day01.Part1(data.ReadDataByFileName("data/day_01.csv"))
	case *day == 1 && *part == 2:
		day01.Part2(data.ReadDataByFileName("data/day_01.csv"))
	default:
		slog.Error("unknown day and part to check", "day", *day, "part", *part)
		os.Exit(1)
	}
}
