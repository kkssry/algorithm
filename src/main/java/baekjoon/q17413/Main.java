package baekjoon.q17413;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] arr = br.readLine().split("");

        boolean isBracket = false;
        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            if (isBracket || s.equals("<")) {
                if (s.equals("<")) {
                    bw.write(sb.reverse().toString());
                    sb = new StringBuilder();
                }
                bw.write(s);
                if (!isBracket) {
                    isBracket = true;
                }
                if (s.equals(">")) {
                    isBracket = false;
                }
            } else {
                if (s.equals(" ")) {
                    bw.write(sb.reverse().toString());
                    bw.write(" ");
                    sb = new StringBuilder();
                } else {
                    sb.append(s);
                }
            }
        }

        bw.write(sb.reverse().toString());
        bw.flush();
    }
}
