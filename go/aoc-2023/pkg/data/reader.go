package data

import (
	"encoding/csv"
	"log/slog"
	"os"
)

func ReadDataByFileName(fileName string) [][]string {
	f, err := os.Open(fileName)
	if err != nil {
		slog.Error("unable to open file", "error", err, "fileName", fileName)
		os.Exit(1)
	}
	defer f.Close()

	csvReader := csv.NewReader(f)
	lines, err := csvReader.ReadAll()
	if err != nil {
		slog.Error("unable to read file", "error", err, "fileName", fileName)
		os.Exit(1)
	}

	return lines
}
