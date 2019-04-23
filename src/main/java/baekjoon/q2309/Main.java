package baekjoon.q2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> tall = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            tall.add(Integer.parseInt(br.readLine()));
        }

        int total = tall.stream().mapToInt(i->i).sum();

        loop :for (int i = 0; i < tall.size()-1; i++) {
            for (int j = i+1; j < tall.size(); j++) {

                if (total - (tall.get(i) + tall.get(j)) == 100) {
                    tall.set(i,-1);
                    tall.set(j,-1);
                    break loop;
                }
            }
        }

        tall.removeIf(i->i==-1);
        Collections.sort(tall);
        tall.stream().forEach(System.out::println);
    }
}
