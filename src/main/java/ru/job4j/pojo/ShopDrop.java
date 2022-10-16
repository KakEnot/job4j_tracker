package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        products[index] = null;//index=3;
        Product temp;
        for (int i = index; i < products.length - 1; i++) {
            temp = products[i + 1];
            products[i + 1] = products[i];
            products[i] = temp;
        }
        return products;
    }
}