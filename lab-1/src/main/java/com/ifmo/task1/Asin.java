package com.ifmo.task1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;
import static java.lang.Math.abs;

public class Asin {

    public static double arcsin(final double x) {
        if (isNaN(x) || abs(x) > 1 ) {
            return NaN;
        }
        return Stream.iterate(0, n -> n + 1)
                .limit(30)
                .mapToDouble(n -> (Math.pow(x, (2 * n + 1)) * factorial(2 * n))
                        / (Math.pow(4, n) * Math.pow(factorial(n), 2) * (2 * n + 1)))
                .sum();
    }

    private static int factorial(final int n) {
        return IntStream.rangeClosed(2, n).parallel().reduce(1, (x, y) -> x * y);
    }
}
