package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}

// Сразу проинициализируйте это поле текущей датой и временем,
// используйте статический метод now().
// Добавьте геттер, чтобы получить доступ к созданному полю.
// Добавьте класс StartUI, в нем создайте один объект Item.
// На этом объекте вызовите геттер поля created, выведите полученную
// дату в консоль в отформатированном варианте, в качестве паттерна
// используйте следующую строку:
// "dd-MMMM-EEEE-yyyy HH:mm:ss"