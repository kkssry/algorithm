package baekjoon.q1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs =  Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] pocketmons = new String[inputs[0]];

        for (int i = 0; i < inputs[0]; i++) {
            pocketmons[i] = br.readLine();
        }

        String[] problems = new String[inputs[1]];
        for (int i = 0; i < inputs[1]; i++) {
            problems[i] = br.readLine();
        }

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < inputs[0]; i++) {
            map.put(pocketmons[i], i);
        }


        for (int i = 0; i < inputs[1]; i++) {
            if (problems[i].charAt(0) -65 >= 0) {
                System.out.println(map.get(problems[i]) + 1);                                   //문자일 경우
            } else {
                System.out.println(pocketmons[Integer.parseInt(problems[i])-1]);             //숫자일 경우
            }
        }


    }
}
