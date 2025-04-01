package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("email@email.com", "Name Surname");
        hashMap.put("email_1@email.com", "Name_1 Surname_1");
        for (String key : hashMap.keySet()) {
            String value = hashMap.get(key);
            System.out.println(key + ";" + value);
        }
    }
}
