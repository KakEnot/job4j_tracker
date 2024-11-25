package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.MockInput;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidateInputTest {

    Random random = new Random();

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenValidInput() {
        Output output = new StubOutput();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(1, 100);
            Input in = new MockInput(
                    new String[]{String.valueOf(number)}
            );
            ValidateInput input = new ValidateInput(output, in);
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(number);
        }
    }

    @Test
    void whenNegativeInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[]{"-1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);
    }

    @Test
    void whenMultipleInput() {
        Output output = new StubOutput();
        String[] answers = new String[]{"3", "100", "0", "-3"};
        Input in = new MockInput(answers);

        for (String answer : answers) {
            ValidateInput input = new ValidateInput(output, in);
            int selected = input.askInt("Enter menu:");
            assertThat(selected).isEqualTo(Integer.parseInt(answer));
        }
    }
}