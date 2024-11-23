package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Console;
import ru.job4j.tracker.output.Output;

public class StartUI {
    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        output.println("Menu:");
        for (int index = 0; index < actions.length; index++) {
            output.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Output output = new Console();
        Input input = new ru.job4j.tracker.input.Console();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new Show(output),
                new Edit(output),
                new Delete(output),
                new FindItemById(output),
                new FindItemsByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}