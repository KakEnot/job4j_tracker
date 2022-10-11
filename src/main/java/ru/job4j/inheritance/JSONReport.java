package ru.job4j.inheritance;

public class JSONReport extends TextReport {
    @Override
    public String generate(String name, String body) {
        String ln = System.lineSeparator();
        return String.format("{" + ln
                + "\t\"name\" : \"" + name + "\"," + ln
                + "\t\"body\" : \"" + body + "\"" + ln
                + "}");
    }
}