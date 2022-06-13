package com.ifmo.math.trigonometric;

import com.ifmo.math.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.*;

class SinTest {

    private Function sin;

    @BeforeEach
    void setUp() {
        sin = new Sin();
    }
    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI/2, -Math.PI/3, -Math.PI/4,
            -Math.PI/6, 0, Math.PI/6, Math.PI/4, Math.PI/3, Math.PI/2})
    void calculate(Double value) {
        assertEquals(Math.sin(value), sin.calculate(value), 0.1);
    }

    @Test
    void nanArgTest() {
        assertTrue(Double.isNaN(sin.calculate(NaN)));
    }
}