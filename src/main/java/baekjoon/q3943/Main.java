package baekjoon.q3943;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        executeTest(count, br, bw);
        bw.flush();
    }

    private static void executeTest(int count, BufferedReader br, BufferedWriter bw) throws IOException {
        int num;
        int max = 0;
        for (int i = 0; i < count; i++) {
            num = Integer.parseInt(br.readLine());
            while(num != 1) {
                if (num > max) {
                    max = num;
                }
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num*=3;
                    num+=1;
                }
            }
            if (max == 0) {
                max = 1;
            }
            bw.write(String.valueOf(max));
            bw.newLine();
            max = 0;
        }
    }
}
