package ru.job4j.tracker.action;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.UserAction;

public class Delete implements UserAction {
    private final Output output;

    public Delete(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete item ===");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            output.println("Заявка удалена успешно.");
        } else {
            output.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
