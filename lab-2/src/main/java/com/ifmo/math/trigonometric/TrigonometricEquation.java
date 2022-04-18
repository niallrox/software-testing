package com.ifmo.math.trigonometric;

import com.ifmo.math.Function;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TrigonometricEquation implements Function {

    private final Function sec;
    private final Function sin;

    @Override
    public double calculate(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("x has to be >= 0");
        }
        return sec.calculate(x) - sin.calculate(x);
    }
}
