package baekjoon.q4673;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= 10000; i++) {
            map.put(i,i);
        }

        for (int i = 1; i <= 10000; i++) { 
            map.remove(callFunc(i));
        }

        for (Integer integer : map.keySet()) {
            System.out.println(integer);
        }

    }

    private static int callFunc(int i) {
        int count = -1;
        int sum = i;
        for (int j = 1; j < 5; j++) {
            if (Math.pow(10,j) == i) {
                count = j + 1;
                break;
            }
            if (Math.pow(10,j) > i) {
                count = j;
                break;
            }
        }

        for (int j = count; j >= 0; j--) {
            if (i > 0) {
                int oneNumber = (int)Math.pow(10,j);
                int mock = i / oneNumber;
                sum += mock;
                i -= (oneNumber * mock);
            }
        }

        return sum;
    }
}
