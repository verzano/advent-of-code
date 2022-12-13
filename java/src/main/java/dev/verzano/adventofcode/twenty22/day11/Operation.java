package dev.verzano.adventofcode.twenty22.day11;

sealed interface Operation {
    long apply(long oldWorry, boolean reduceWorry, long leastCommonMultiple);

    /*
      Operation: new = old * 19
     */
    static Operation fromString(String operationS) {
        var parts = operationS.split(" ");
        var operator = parts[4];
        var operand = parts[5];
        return switch (operator) {
            case "*" -> {
                if (operand.equals("old")) yield new Square();
                yield new Multiply(Long.parseLong(operand));
            }
            case "+" -> new Add(Long.parseLong(operand));
            default -> throw new RuntimeException("Unknown operation for String: " + operationS);
        };
    }

    final class Square implements Operation {
        @Override
        public long apply(long oldWorry, boolean reduceWorry, long leastCommonMultiple) {
            var tmp = oldWorry * oldWorry;
            return reduceWorry ? tmp / 3 : tmp % leastCommonMultiple;
        }
    }

    final class Multiply implements Operation {
        private final long operand;

        public Multiply(long operand) {
            this.operand = operand;
        }

        @Override
        public long apply(long oldWorry, boolean reduceWorry, long leastCommonMultiple) {
            var tmp = oldWorry * operand;
            return reduceWorry ? tmp / 3 : tmp % leastCommonMultiple;
        }
    }

    final class Add implements Operation {
        private final long operand;

        public Add(long operand) {
            this.operand = operand;
        }

        @Override
        public long apply(long oldWorry, boolean reduceWorry, long leastCommonMultiple) {
            var tmp = oldWorry + operand;
            return reduceWorry ? tmp / 3 : tmp % leastCommonMultiple;
        }
    }
}
