package baekjoon.q2755;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int subjectCount = Integer.parseInt(br.readLine());

        Subject[] subjects = new Subject[subjectCount];
        initSubjects(subjects, br);
        Map<String, Float> grades = new HashMap<>();
        initgrades(grades);
        saveTotalCredit(subjects, grades);
    }

    private static void saveTotalCredit(Subject[] subjects, Map<String, Float> grades) {
        float result = 0;
        float credit = 0;
        for (Subject subject : subjects) {
            credit += Float.parseFloat(subject.credit);
            result += Float.parseFloat(subject.credit) * grades.get(subject.grade);
        }
        result /= credit;
        System.out.println(String.format("%.2f", result));
    }

    private static void initgrades(Map<String, Float> grades) {
        grades.put("A+", 4.3F);grades.put("A0", 4.0F);grades.put("A-", 3.7F);
        grades.put("B+", 3.3F);grades.put("B0", 3.0F);grades.put("B-", 2.7F);
        grades.put("C+", 2.3F);grades.put("C0", 2.0F);grades.put("C-", 1.7F);
        grades.put("D+", 1.3F);grades.put("D0", 1.0F);grades.put("D-", 0.7F);
        grades.put("F", 0.0F);
    }

    private static void initSubjects(Subject[] subjects, BufferedReader br) throws IOException {
        for (int i = 0; i < subjects.length; i++) {
            String[] subjectSpec = br.readLine().split(" ");
            subjects[i] =  new Subject(subjectSpec[1], subjectSpec[2]);
        }
    }

    static class Subject {
        String credit;
        String grade;

        Subject(String score, String grade) {
            this.credit = score;
            this.grade = grade;
        }
    }
}
