package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String tempLeft = left.split("/")[0];
        String tempRight = right.split("/")[0];
        if (tempLeft.compareTo(tempRight) == 0) {
            return left.compareTo(right);
        }
        return right.compareTo(left);
    }
}