package baekjoon.q1149;


import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MainTest {
    @Test
    public void mainTest()  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = 3;
        int[][] houses = new int[3][3];

        for (int i = 0; i < input; i++) {
            try {
                houses[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Arrays.deepToString(houses));
    }
}