package ru.job4j.collection;

import java.util.Comparator;
import java.util.List;

public class DepartmentsDescComparator implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        String tempLeft = List.of(left.split("/")).get(0);
        String tempRight = List.of(right.split("/")).get(0);
        if (!tempLeft.equals(tempRight)) {
            return tempRight.compareTo(tempLeft);
        }
        return left.compareTo(right);
    }
}