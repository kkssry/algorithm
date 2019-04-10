package programmers.q12987;


import java.util.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;


        boolean[] bol = new boolean[B.length];
        recursive(A,B,bol);
        for (int i = 0; i < A.length; i++) {
            if (A[i] < B[i]) {
                answer++;
            }
        }

        System.out.println(Arrays.toString(B));

        return answer;
    }

    private void recursive(int[] a, int[] b, boolean[] bol) {
        List<Integer> list = new LinkedList<>();
        int p = -1;
        int o = -1;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] <= b[j]) {
                    if (!bol[j]) {
                        list.add(b[j]);
//                        System.out.println(b[j]);
//                        bol[i] = true;
//                        int tmp = b[j];
//                        b[j] = b[i];
//                        b[i] = tmp;
//                        break;
                    }
                }
            }
//            bol[i] = true;

            Collections.sort(list);
            System.out.println(list);
            for (int j = 0; j < b.length; j++) {
                if (list.size() > 1) {
                    if (b[j] == list.get(0)) {
                        bol[i] = true;
                        int tmp = b[j];
                        b[j] = b[i];
                        b[i] = tmp;
                    }
                }
            }
            list.clear();

        }
    }


}
