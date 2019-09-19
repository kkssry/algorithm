package baekjoon.q7696;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>(1_000_000);
        Map<Integer, Integer> map = new HashMap<>();
        initList(list, map);

        int countDownNumber;
        while ((countDownNumber = sc.nextInt()) != 0) {
            bw.write(String.valueOf(list.get(countDownNumber - 1)));
//            bw.write(String.valueOf(map.get(countDownNumber)));
            bw.newLine();
        }
        bw.flush();
    }

    private static void initList(List<Integer> list, Map<Integer, Integer> map) {       // map이 리스트 보다 메모리를 약 2.5배 많이 드며 시간도 100ms 느렸다.
        boolean[] manageCheck = new boolean[10];
        int number = 0;
        int index;
        boolean isDuplicate;
        int size = 0;


        while (size <= 1_000_000) {
            initManageCheck(manageCheck);
            number++;
            int copyNum = number;
            isDuplicate = false;

            while (copyNum != 0) {
                index = copyNum % 10;
                copyNum /= 10;
                if (manageCheck[index]) {
                    isDuplicate = true;
                    break;
                } else {
                    manageCheck[index] = true;
                }
            }

            if (!isDuplicate) {
                size++;
//                map.put(size, number);
                list.add(number);
            }
        }

    }

    private static void initManageCheck(boolean[] manageCheck) {
        for (int i = 0; i < manageCheck.length; i++) {
            manageCheck[i] = false;
        }
    }


}
