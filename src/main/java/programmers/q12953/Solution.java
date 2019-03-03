package programmers.q12953;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] arr) {
        long start = System.currentTimeMillis();
        List<Integer> divider = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        int min = min(list);
        if (min == 0) {
            return 0;
        }
        int answer = 1;
        int count = 0;

        do {
                int max = (int)Math.sqrt(max(list));
            loop: for (int i = 2; i <= max; i++) {
                count = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) % i == 0) {
                        count++;
                    }
                }
                if (count >= 2) {
                    divider.add(i);
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j) % i == 0) {
                            list.set(j, list.get(j) / i);
                        }
                    }
                    break loop;
                }
            }
        } while (count >= 2);

        System.out.println(divider);
        System.out.println(list);

        for (int i = 0; i < divider.size(); i++) {
            answer *= divider.get(i);
        }

        for (int i = 0; i < list.size(); i++) {
            answer *= list.get(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (end-start));
        return answer;
    }

    public int max(List<Integer> list) {
        int tmp = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (tmp < list.get(i)) {
                tmp = list.get(i);
            }
        }
        return tmp;
    }

    public int min(List<Integer> list) {
        int tmp = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (tmp > list.get(i)) {
                tmp = list.get(i);
            }
        }
        return tmp;
    }
}
