package baekjoon.find.rule.q1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] arr = input.split("");
        Map<Integer, Integer> numberManage = new HashMap<>();

        for (int i = 0; i <= 9; i++) {
            numberManage.put(i,0);
        }

        for (int i = 0; i < arr.length; i++) {
            int num = Integer.parseInt(arr[i]);
            numberManage.put(num, numberManage.get(num)+1);
        }

        if (arr.length != 1) {
            int sixNine = numberManage.get(6) + numberManage.get(9);
            if (sixNine % 2 == 1) {
                sixNine = (sixNine - 1) / 2;
                numberManage.put(6, sixNine + 1);
            } else {
                numberManage.put(6, sixNine / 2);
            }
        }

        numberManage.put(9,0);
        System.out.println(numberManage.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue());

    }
}
