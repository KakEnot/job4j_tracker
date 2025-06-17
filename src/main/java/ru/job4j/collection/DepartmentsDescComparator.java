package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String tempLeft = left.split("/")[0];
        String tempRight = right.split("/")[0];
        int result = tempRight.compareTo(tempLeft);
        return result != 0 ? result : left.compareTo(right);
    }
}