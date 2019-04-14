package programmers.q12936;

import java.util.*;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new LinkedList<>();
        int index = 0;
//        int elementIndex = 0;
//        BigInteger k1 = BigInteger.valueOf(k);            // 주석 처리 부분 : 20!도 할 수있다는 생각에
                                                            // BigInteger로 했지만 효율성 2개에서 탈락함..

        if (n == 2) {
            if ((int) k == 1) {
                return new int[]{1, 2};
            }
            return new int[]{2, 1};
        }

        long fac = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }

//        BigInteger fac = BigInteger.ONE;
//        for (int i = 1; i <= n; i++) {
//            list.add(i);
//            fac = fac.multiply(BigInteger.valueOf(i));
//        }

        while (k > 0) {
            fac /= n--;

            long findFirstIndex = k / fac;

            k %= fac;
            
            if (k == 0) {
                findFirstIndex--;
            }

            answer[index] = list.get((int)findFirstIndex);
            list.remove((int)findFirstIndex);

            index++;

        }

//        while (k1.intValue() > 0) {
//            fac = fac.divide(BigInteger.valueOf(n));
//            n--;
//
//            BigInteger findFirstIndex = k1.divide(fac);
//            elementIndex = findFirstIndex.intValue();
//
//            k1 = k1.remainder(fac);
//
//            if (k1.intValue() == 0) {
//                elementIndex -= 1;
//            }
//
//            answer[index] = list.get(elementIndex);
//            list.remove(elementIndex);
//
//            index++;
//            System.out.println(k1.intValue());
//        }


        if (k == 0) {
            Collections.reverse(list);
        }

//        if (k1.intValue() == 0) {
//            Collections.reverse(list);
//        }


        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = list.get(0);
                list.remove(0);
            }
        }

        return answer;
    }

}

