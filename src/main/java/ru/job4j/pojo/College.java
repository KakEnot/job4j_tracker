package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Иванов Иван Иванович");
        student.setGroupNumber(1230);
        student.setReceiptDate(LocalDate.now());

        System.out.printf("ФИО: %s \nНомер группы: %d \nДата поступления: %tF%n",
                student.getFullName(),
                student.getGroupNumber(),
                student.getReceiptDate());
    }
}
