package com.ifmo.math.trigonometric;

import com.ifmo.math.Function;

import java.util.stream.Stream;

import static java.lang.Math.pow;

public class Sin implements Function {

    @Override
    public double calculate(double x) {

        return Stream.iterate(0, n -> n + 1)
                .limit(30)
                .mapToDouble(n -> pow(-1, n) * pow(x, 2 * n - 1) / factorial(2 * n - 1))
                .sum();
    }
}