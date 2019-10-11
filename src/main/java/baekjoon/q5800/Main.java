package baekjoon.q5800;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        executeTest(count, br, bw);
        bw.flush();
    }

    private static void executeTest(int count, BufferedReader br, BufferedWriter bw) throws IOException {
        for (int i = 0; i < count; i++) {
            String[] arr = br.readLine().split(" ");
            int[] scores = Arrays.stream(Arrays.copyOfRange(arr, 1, arr.length)).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(scores);
            saveResult(i, bw, scores);
        }
    }

    private static void saveResult(int i, BufferedWriter bw, int[] scores) throws IOException {
        bw.write("Class " + (i + 1) + "\n");
        int largestGap = saveLargestGap(scores);
        int max = scores[scores.length - 1];
        int min = scores[0];
        bw.write("Max " + max + ", " +"Min " + min + ", " + "Largest gap " + largestGap + "\n");
    }

    private static int saveLargestGap(int[] scores) {
        int largestGap = 0;
        int gap;
        for (int i = scores.length - 1; i >= 1; i--) {
            gap = scores[i] - scores[i - 1];
            if (largestGap < gap) {
                largestGap = gap;
            }
        }
        return largestGap;
    }
}
