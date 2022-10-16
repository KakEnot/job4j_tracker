package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("book1", 10);
        Book book2 = new Book("book2", 20);
        Book book3 = new Book("book3", 40);
        Book book4 = new Book("Clean code", 40);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book bk : books) {
            System.out.println(bk.getName() + "-" + bk.getCountPages());
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book bk : books) {
            System.out.println(bk.getName() + "-" + bk.getCountPages());
        }

        for (Book bk : books) {
            if ("Clean code".equals(bk.getName())) {
                System.out.println(bk.getName() + "-" + bk.getCountPages());
            }
        }
    }
}
