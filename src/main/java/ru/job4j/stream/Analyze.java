package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(
                        pupil -> new Tuple(pupil.name(),
                                pupil.subjects().stream()
                                        .mapToInt(Subject::score)
                                        .average()
                                        .orElse(0D)))
                .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, averagingDouble(Subject::score)))
                .entrySet().stream()
                .map(value -> new Tuple(value.getKey(), value.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(
                        pupil -> new Tuple(pupil.name(),
                                pupil.subjects().stream()
                                        .mapToInt(Subject::score)
                                        .sum()))
                .max(Comparator.comparingInt(t -> (int) t.score()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(groupingBy(Subject::name, LinkedHashMap::new, summingDouble(Subject::score)))
                .entrySet().stream()
                .map(value -> new Tuple(value.getKey(), value.getValue()))
                .max(Comparator.comparingDouble (Tuple::score))
                .orElse(null);
    }
}