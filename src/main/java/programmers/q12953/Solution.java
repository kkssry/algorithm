package programmers.q12953;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] arr) {
        List<Integer> divider = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Collections.sort(list);

        int answer = 1;
        int count;
        int max = list.get(list.size()-2);

        for (int i = 2; i < max; i++) {
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
                        list.set(j,list.get(j)/i);
                    }
                }
            }
        }
        for (int i = 2; i < max; i++) {
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
                        list.set(j,list.get(j)/i);
                    }
                }
            }
        }



        System.out.println(divider);
        System.out.println(list);

        for (int i = 0; i < divider.size(); i++) {
            answer *= divider.get(i);
        }

        for (int i = 0; i < list.size(); i++) {
            answer *= list.get(i);
        }

        return answer;
    }

    private int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    private void divideZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {

        }
    }
}
