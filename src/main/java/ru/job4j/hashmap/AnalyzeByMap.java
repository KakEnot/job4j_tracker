package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int countSubject = 0;
        int sumScore = 0;
        for (Pupil pupil : pupils) {
            countSubject += pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
        }
        return (double) sumScore / countSubject;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int sumScore = 0;
            int countSubject = pupil.subjects().size();
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            labels.add(new Label(pupil.name(), (double) sumScore / countSubject));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        int countPupils = pupils.size();

        HashMap<String, Double> subjects = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjects.merge(subject.name(), (double) subject.score(), Double::sum);
            }
        }

        List<Label> labelList = new ArrayList<>();
        for (String subject : subjects.keySet()) {
            labelList.add(new Label(subject, subjects.get(subject) / countPupils));
        }

        return labelList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestPupil = new Label("", 0D);
        for (Pupil pupil : pupils) {
            int sumScore = 0;
            for (Subject subject : pupil.subjects()) {
                sumScore += subject.score();
            }
            if (bestPupil.score() < sumScore) {
                bestPupil = new Label(pupil.name(), sumScore);
            }

        }
        return bestPupil;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Label bestSubject = new Label("", 0D);
        HashMap<String, Double> subjects = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjects.merge(subject.name(), (double) subject.score(), Double::sum);
            }
        }

        for (String subject : subjects.keySet()) {
            if (bestSubject.score() < subjects.get(subject)) {
                bestSubject = new Label(subject, subjects.get(subject));
            }
        }
        return bestSubject;
    }
}