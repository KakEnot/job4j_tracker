package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> findPhone = person -> person.getPhone().contains(key);
        Predicate<Person> findName = person -> person.getName().contains(key);
        Predicate<Person> findAddress = person -> person.getAddress().contains(key);
        Predicate<Person> findSurname = person -> person.getSurname().contains(key);
        Predicate<Person> combine = findPhone.or(findName.or(findAddress.or(findSurname)));

        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}