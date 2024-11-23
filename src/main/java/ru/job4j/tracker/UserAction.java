package ru.job4j.tracker;

import ru.job4j.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}

