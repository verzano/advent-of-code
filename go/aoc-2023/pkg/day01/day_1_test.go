package day01

import (
	"aoc-2023/pkg/data"
	"testing"
)

func TestRotate(t *testing.T) {
	tests := []struct {
		name         string
		dial         int
		direction    string
		distance     int
		expectedDial int
		zeroed       bool
	}{
		{"turn L", 50, "L", 1, 49, false},
		{"turn R", 50, "R", 1, 51, false},
		{"turn past 99", 99, "R", 1, 0, true},
		{"turn FAR past 99", 50, "R", 500, 50, true},
		{"turn past 0", 0, "L", 1, 99, true},
		{"turn FAR past 0", 50, "L", 500, 50, true},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			zeroed := rotate(&tt.dial, tt.direction, tt.distance)

			if tt.dial != tt.expectedDial {
				t.Errorf("final dial position was %d, but should have been %d", tt.dial, tt.expectedDial)
			}

			if zeroed != tt.zeroed {
				t.Errorf("zeroed return was %t, but should have been %t", zeroed, tt.zeroed)
			}
		})
	}
}

func TestPart1(t *testing.T) {
	tests := []struct {
		name          string
		filename      string
		expectedZeros int
	}{
		{"test 1", "day_01_test.csv", 3},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			lines := data.ReadDataByFileName("testdata/" + tt.filename)
			actualZeroes := Part1(lines)

			if actualZeroes != tt.expectedZeros {
				t.Errorf("actual zero count was %d, but should have been %d", actualZeroes, tt.expectedZeros)
			}
		})
	}
}

func TestPart2(t *testing.T) {
	tests := []struct {
		name          string
		filename      string
		expectedZeros int
	}{
		{"test 1", "day_01_test.csv", 6},
	}

	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			lines := data.ReadDataByFileName("testdata/" + tt.filename)
			actualZeroes := Part2(lines)

			if actualZeroes != tt.expectedZeros {
				t.Errorf("actual zero count was %d, but should have been %d", actualZeroes, tt.expectedZeros)
			}
		})
	}
}
