package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();

        for (Item item : items) {
            if (key.equals(item.getName())) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(id - 1) : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = id;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            items.add(i - 1, item);
            item.setId(id);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            items.remove(i - 1);
        }
        return rsl;
    }
}