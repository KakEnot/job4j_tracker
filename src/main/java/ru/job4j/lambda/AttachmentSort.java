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

        Comparator<Attachment> comparatorByName = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                String o1Name = o1.getName();
                String o2Name = o2.getName();
                return o1Name.compareTo(o2Name);
            }
        };
        attachments.sort(comparatorByName);
        System.out.println(attachments);
    }
}