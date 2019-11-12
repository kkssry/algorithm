package baekjoon.q5789;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            int index = line.length() / 2;
            if (line.charAt(index) == line.charAt(index - 1)) {
                bw.write("Do-it\n");
            } else {
                bw.write("Do-it-Not\n");
            }
        }
        bw.flush();
    }
}
