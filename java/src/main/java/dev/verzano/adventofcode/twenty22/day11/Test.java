package dev.verzano.adventofcode.twenty22.day11;

record Test(long divisor, int trueMonkey, int falseMonkey) {
    int getMonkeyToThrowTo(long worryLevel) {
        return worryLevel % divisor == 0 ? trueMonkey : falseMonkey;
    }

    /*
      Test: divisible by 23
        If true: throw to monkey 2
        If false: throw to monkey 3
     */
    public static Test fromStrings(String divisorS, String trueMonkeyS, String falseMonkeyS) {
        var divisor = Long.parseLong(divisorS.split(" by ")[1]);
        var trueMonkey = Integer.parseInt(trueMonkeyS.split(" monkey ")[1]);
        var falseMonkey = Integer.parseInt(falseMonkeyS.split(" monkey ")[1]);
        return new Test(divisor, trueMonkey, falseMonkey);
    }
}
