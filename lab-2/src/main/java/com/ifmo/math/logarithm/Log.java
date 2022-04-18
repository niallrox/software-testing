package com.ifmo.math.logarithm;

import com.ifmo.math.Function;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class Log implements Function {

    private final Function ln;
    private final double base;

    @Override
    public double calculate(double x) {
        return ln.calculate(x) / ln.calculate(base);
    }
}
