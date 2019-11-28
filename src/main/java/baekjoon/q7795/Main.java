package baekjoon.q7795;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            br.readLine();
            int[] x = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] y = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(y);
            bw.write(compareXY(x, y) + "\n");
        }
        bw.flush();
    }

    private static int compareXY(int[] x, int[] y) {
        int sum = 0;
        for (int value : x) {
            for (int i : y) {
                if (value > i) {
                    sum++;
                } else {
                    break;
                }
            }
        }
        return sum;
    }


}
