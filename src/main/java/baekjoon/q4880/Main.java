package baekjoon.q4880;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while(!(line=br.readLine()).equals("0 0 0")) {
            int[] arr = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (isSamePlus(arr)) {
                int number = arr[2] + (arr[2] - arr[1]);
                bw.write("AP " + number + "\n");
                continue;
            }
            if (isSameMultiply(arr)) {
                int number = arr[2] * (arr[2]/arr[1]);
                bw.write("GP " + number + "\n");
            }
        }
        bw.flush();
    }

    private static boolean isSameMultiply(int[] arr) {
        return (arr[1] / arr[0]) == (arr[2] / arr[1]);
    }

    private static boolean isSamePlus(int[] arr) {
        return (arr[1] - arr[0]) == (arr[2] - arr[1]);
    }
}
