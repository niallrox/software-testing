package com.ifmo.math;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SystemEquation implements Function {
    private final Function trigonometricEquation;
    private final Function logarithmEquation;

    @Override
    public double calculate(double x) {
        return x <= 0 ? trigonometricEquation.calculate(x) : logarithmEquation.calculate(x);
    }
}
