package com.ifmo.math.logarithm;

import com.ifmo.math.Function;
import lombok.Builder;

import static java.lang.Math.pow;

@Builder
public class LogarithmEquation implements Function {

    private final Function ln;
    private final Function log2;
    private final Function log3;
    private final Function log5;
    private final Function log10;

    @Override
    public double calculate(double x) {
        if (x >= 0) {
            throw new IllegalArgumentException("x has to be < 0");
        }
        return ((
                ((log10.calculate(x) + log3.calculate(x)) * ln.calculate(x) / log2.calculate(x))
                        + (pow(log10.calculate(x), 2))) + (log5.calculate(x)
                - ((pow(log10.calculate(x) + log2.calculate(x), 2)) + (log2.calculate(x) * log5.calculate(x)))
        ));
    }
}
