package baekjoon.q1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(br.readLine());

        List<String> vocas = new ArrayList<>();

        for (int i = 0; i < numCount; i++) {
            vocas.add(br.readLine());
        }

        Collections.sort(vocas, (o1, o2) -> {
            if (o1.length() > o2.length()) {
                return 1;
            }
            if (o1.length() < o2.length()) {
                return -1;
            }
            return o1.compareTo(o2);
        });

        vocas.stream().distinct().forEach(System.out::println);
    }
}
