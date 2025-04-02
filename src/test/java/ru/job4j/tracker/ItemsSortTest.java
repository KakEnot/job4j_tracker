package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemsSortTest {

    @Test
    void whenItemsSortDescByName() {
        Item item1 = new Item("1test");
        Item item2 = new Item("2test");
        Item item3 = new Item("3test");
        Item item4 = new Item("4test");

        List<Item> items = new ArrayList<>();
        items.add(item4);
        items.add(item2);
        items.add(item1);
        items.add(item3);

        items.sort(new ItemDescByName());

        List<Item> expected = List.of(item4, item3, item2, item1);

        assertThat(items).containsExactlyElementsOf(expected);
    }

    @Test
    void whenItemsSortAscByName() {
        Item item1 = new Item("1test");
        Item item2 = new Item("2test");
        Item item3 = new Item("3test");
        Item item4 = new Item("4test");

        List<Item> items = new ArrayList<>();
        items.add(item4);
        items.add(item2);
        items.add(item1);
        items.add(item3);

        items.sort(new ItemAscByName());

        List<Item> expected = List.of(item1, item2, item3, item4);

        assertThat(items).containsExactlyElementsOf(expected);
    }
}