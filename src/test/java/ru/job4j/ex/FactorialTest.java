package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertThrows;

public class FactorialTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Factorial().calc(-1);
        });
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void factorialSuccess() {
        int number = 4;
        int expected = 24;
        int result = new Factorial().calc(number);
        assertThat(result).isEqualTo(expected);
    }
}
