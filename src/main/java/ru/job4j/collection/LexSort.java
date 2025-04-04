package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(getInt(left), getInt(right));
    }

    private Integer getInt(String str) {
        return Integer.parseInt(str.split("\\.")[0]);
    }
}