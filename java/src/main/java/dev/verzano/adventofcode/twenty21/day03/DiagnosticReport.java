package dev.verzano.adventofcode.twenty21.day03;

public record DiagnosticReport(int gamma, int epsilon, int co2Scrubber, int oxygenGenerator) {
    public int powerConsumption() {
        return gamma * epsilon;
    }

    public int lifeSupportRating() {
        return co2Scrubber * oxygenGenerator;
    }

    @Override
    public String toString() {
        return "DiagnosticReport{" +
                "gamma=" + gamma +
                ", epsilon=" + epsilon +
                ", co2Scrubber=" + co2Scrubber +
                ", oxygenGenerator=" + oxygenGenerator +
                '}';
    }
}
