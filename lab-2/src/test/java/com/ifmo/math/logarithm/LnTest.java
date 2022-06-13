package com.ifmo.math.logarithm;

import com.ifmo.math.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

    @Disabled
    @ParameterizedTest
    @ValueSource(doubles = {0.5, 1.7, 0.34, 5, 10})
    void calculate(double value) {
        assertEquals(Math.log(value), ln.calculate(value));
    }
}