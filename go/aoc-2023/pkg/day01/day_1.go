package day01

import (
	"fmt"
	"log/slog"
	"os"
	"regexp"
	"strconv"
)

var turnRegex = regexp.MustCompile(`([LR])(\d+)`)

func rotate(dial *int, direction string, distance int) bool {
	zeroed := false
	switch direction {
	case "L":
		if distance > *dial {

		}
		*dial -= distance
	case "R":
		*dial += distance
	}

	if *dial > 99 {
		*dial %= 100
		zeroed = true
	} else if *dial < 0 {
		*dial %= 100
		*dial += 100
		zeroed = true
	} else if *dial == 0 {
		zeroed = true
	}

	return zeroed
}

func Part1(lines [][]string) int {
	dial := new(int)
	*dial = 50
	//fmt.Printf("starting dial position: %d\n", *dial)

	countOfZeros := 0
	//for i, line := range lines {
	for _, line := range lines {
		turn := line[0]
		groups := turnRegex.FindStringSubmatch(turn)

		direction := groups[1]
		distance, err := strconv.Atoi(groups[2])
		if err != nil {
			slog.Error("error reading turn", "error", err, "turn", turn)
			os.Exit(1)
		}

		//fmt.Printf("turn %d -- direction: %s, distance: %d\n", i, direction, distance)
		rotate(dial, direction, distance)
		//fmt.Printf("new dial position: %d\n", *dial)

		if *dial == 0 {
			countOfZeros++
			//fmt.Print("found a zero!\n")
		}
	}

	fmt.Printf("count of zeros: %d\n", countOfZeros)
	return countOfZeros
}

func Part2(lines [][]string) int {
	dial := new(int)
	*dial = 50
	fmt.Printf("starting dial position: %d\n", *dial)

	countOfZeros := 0
	for i, line := range lines {
		//for _, line := range lines {
		turn := line[0]
		groups := turnRegex.FindStringSubmatch(turn)

		direction := groups[1]
		distance, err := strconv.Atoi(groups[2])
		if err != nil {
			slog.Error("error reading turn", "error", err, "turn", turn)
			os.Exit(1)
		}

		fmt.Printf("turn %d -- direction: %s, distance: %d\n", i, direction, distance)
		zeroed := rotate(dial, direction, distance)
		fmt.Printf("new dial position: %d\n", *dial)

		if zeroed {
			countOfZeros++
			fmt.Print("found a zero!\n")
		}
	}

	fmt.Printf("count of zeros: %d\n", countOfZeros)
	return countOfZeros
}
