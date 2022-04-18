package com.ifmo.math;

import java.util.stream.IntStream;

public interface Function {
    double calculate(final double x);
    default int factorial(final int n) {
        return IntStream.rangeClosed(2, n).parallel().reduce(1, (x, y) -> x * y);
    }
}
