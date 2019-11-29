package baekjoon.q12605;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] arr = br.readLine().split(" ");
            bw.write("Case #" + (i + 1) + ": ");
            saveResult(arr, bw);
        }
        bw.flush();
    }

    private static void saveResult(String[] arr, BufferedWriter bw) throws IOException {
        for (int i = arr.length - 1; i >= 0; i--) {
            bw.write(arr[i]);
            bw.write(" ");
        }
        bw.newLine();
    }
}
