package com.ifmo.math.trigonometric;

import com.ifmo.math.Function;

import java.util.stream.Stream;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Sec implements Function {

    @Override
    public double calculate(double x) {
        if (PI / 2 == x) {
            throw new IllegalArgumentException("x can not be PI/2 in sec");
        }

        return 1 / (Stream.iterate(0, n -> n + 1)
                .limit(15)
                .mapToDouble(n -> pow(-1, n) * pow(x, 2 * n) / factorial(2 * n))
                .sum());
    }
}
