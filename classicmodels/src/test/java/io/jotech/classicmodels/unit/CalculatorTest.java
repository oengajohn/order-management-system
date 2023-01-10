package io.jotech.classicmodels.unit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.jotech.classicmodels.misc.Calculator;

class CalculatorTest {
    @Test
    @DisplayName("when add two positive numbers")
    void whenAddTwoPositiveNumbers() {
        Calculator calculator = new Calculator();
        int a = 12, b = 34;

        int actual = calculator.add(a, b);
        int expected = 46;
        Assertions.assertThat(actual).isEqualTo(expected);
    }


}