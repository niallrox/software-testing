package com.ifmo.math.trigonometric;

import com.ifmo.math.Function;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Float.NaN;
import static org.junit.jupiter.api.Assertions.*;

public class SecTest {


    private Function sec;

    @BeforeEach
    void setUp() {
        sec = new Sec();
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(doubles = {-Math.PI/2, -Math.PI/3, -Math.PI/4,
            -Math.PI/6, 0, Math.PI/6, Math.PI/4, Math.PI/3})
    void calculate(Double value) {
        assertEquals(1 / Math.cos(value), sec.calculate(value), 0.1);
    }

    @Test
    void zeroDivision() {
        assertThrows(IllegalArgumentException.class, () -> sec.calculate(Math.PI / 2));
    }

    @Test
    void nanArgTest() {
        assertTrue(Double.isNaN(sec.calculate(NaN)));
    }
}
