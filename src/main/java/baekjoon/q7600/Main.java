package baekjoon.q7600;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while(!(line=br.readLine()).equals("#")) {
            line = line.toLowerCase();
            boolean[] isChecked = new boolean[26];
            int count = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
                    isChecked[line.charAt(i) - 'a'] = true;
                }
            }
            for (boolean b : isChecked) {
                if (b) {
                    count++;
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
    }
}
