package baekjoon.simul;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int targetNumber = input[0];
        int limitNumber = input[1];
        int coreNum = -1;
        int executeCount = -1;


        for (int i = limitNumber; i <= 100; i++) {
            coreNum = callFormal(targetNumber, i, coreNum);
            if (coreNum < 0) {
                continue;
            }
            executeCount = i;
            break;
        }

        if (executeCount == -1) {
            System.out.println(-1);
            return;
        }

        String[] nums = new String[executeCount];

        for (int i = 0; i < executeCount; i++) {
            nums[i] = ""+coreNum++;
        }

        System.out.println(String.join(" ",nums));
    }

    private static int callFormal(int targetNumber, int i, int coreNUm) {
        int sumRest = callRest(i);
        if ((targetNumber - sumRest) % i == 0) {
            coreNUm = (targetNumber - sumRest) / i;
        }
        return coreNUm;
    }

    private static int callRest(int i) {
        return (i-1) * i / 2;
    }
}
