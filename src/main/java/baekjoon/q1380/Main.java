package baekjoon.q1380;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> lostEarringPeople = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            System.out.println(line);
            if (line.equals("")) {
                line = br.readLine();
            }
            int count = Integer.parseInt(line);
            if (count == 0) {
                break;
            }
            String[] people = new String[count];
            initPeople(people, br);
            findLostEarring(people, lostEarringPeople, br);
            System.out.println(line);
        }

        printResult(lostEarringPeople, bw);
        bw.flush();
    }

    private static void printResult(List<String> lostEarringPeople, BufferedWriter bw) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lostEarringPeople.size(); i++) {
            sb.append(i+1).append(" ").append(lostEarringPeople.get(i)).append(System.lineSeparator());
        }
        bw.write(sb.toString());
    }

    private static void findLostEarring(String[] people, List<String> lostEarringPeople, BufferedReader br) throws IOException {
        boolean[] isChecked = new boolean[people.length];
        for (int i = 0; i < people.length * 2 - 1; i++) {
            int index = Integer.parseInt(br.readLine().split(" ")[0]) - 1;
            System.out.println(index);
            isChecked[index] = !isChecked[index];
        }

        for (int i = 0; i < isChecked.length; i++) {
            if (isChecked[i]) {
                lostEarringPeople.add(people[i]);
                break;
            }
        }
    }

    private static void initPeople(String[] people, BufferedReader br) throws IOException {
        for (int i = 0; i < people.length; i++) {
            people[i] = br.readLine();
        }
    }
}
