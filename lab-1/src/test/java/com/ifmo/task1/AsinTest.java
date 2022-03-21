package com.ifmo.task1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.ifmo.task1.Asin.arcsin;
import static java.lang.Double.NaN;
import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static org.junit.jupiter.api.Assertions.*;

public class AsinTest {

    @ParameterizedTest
    @ValueSource(doubles = {-PI / 2, -PI / 3, -PI / 4, -PI / 6,
            0.0, PI / 6, PI / 4, PI / 3, PI / 2})
    public void testArcsinValidInput(double value) {
        assertEquals(Math.asin(sin(value)), arcsin(sin(value)), 0.3, String.format("Test failed with input %s", value));
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1.1, 1.1, NaN})
    public void testArcsinInvalidInput(double value) {
        assertEquals(NaN, arcsin(value),  String.format("Test failed with input %s", value));
    }
}