package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);
        // Здесь создайте компаратор на основании анонимного класса.

        Comparator<Attachment> comparatorByName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                String o1Name = o1.getName();
                String o2Name = o2.getName();
                int minSize = Math.min(o1Name.length(), o2Name.length());
                for (int i = 0; i < minSize; i++) {
                    int result = Character.compare(o1Name.charAt(i), o2Name.charAt(i));
                    if (result != 0) {
                        return result;
                    }
                }

                return Integer.compare(o1Name.length(), o2Name.length());
            }
        };
        attachments.sort(comparatorByName);
        System.out.println(attachments);
    }
}