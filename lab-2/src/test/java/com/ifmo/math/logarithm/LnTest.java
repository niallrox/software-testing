package com.ifmo.math.logarithm;

import com.ifmo.math.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class LnTest {

    private Function ln;

    @BeforeEach
    void setUp() {
        ln = new Ln();
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.5, 1.7, 0.34, 5, 10})
    void calculate(double value) {
        double expected = new BigDecimal(Double.toString(Math.log(1 + value)))
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
        double actual = new BigDecimal(Double.toString(ln.calculate(1 + value)))
                .setScale(4, RoundingMode.HALF_UP)
                .doubleValue();
        assertEquals(expected, actual);
    }
}