package baekjoon.q2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] testCount = new int[3];
        String[] result = new String[3];
        playYut(testCount,br,result);
        Arrays.stream(result).forEach(System.out::println);

    }

    private static void playYut(int[] testCount, BufferedReader br, String[] result) throws IOException {
        for (int i = 0; i < testCount.length; i++) {
            int[] yut = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            result[i] = judgeResult(yut);
        }
    }

    private static String judgeResult(int[] yut) {
        String resultValue = "";
        int zeroCount = 0;
        for (int i1 : yut) {
            if (i1 == 0) {
                zeroCount++;
            }
        }

        switch (zeroCount) {
            case 1 :
                resultValue = "A";
                break;
            case 2 :
                resultValue = "B";
                break;
            case 3 :
                resultValue = "C";
                break;
            case 4 :
                resultValue = "D";
                break;
            default :
                resultValue = "E";
                break;
        }

        return resultValue;
    }
}
