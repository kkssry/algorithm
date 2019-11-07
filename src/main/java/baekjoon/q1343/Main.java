package baekjoon.q1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine() + " ";
        StringBuilder sb = new StringBuilder();
        int count = 0;
        boolean isPossible = true;

        for (int i = 0; i < problem.length(); i++) {
            char ch = problem.charAt(i);
            if (ch == 'X') {
                count++;
                continue;
            }

            if (count % 2 != 0) {
                isPossible = false;
                System.out.println(-1);
                break;
            } else {
                int fourMock = count / 4;
                for (int j = 0; j < fourMock; j++) {
                    sb.append("AAAA");
                }
                count -= fourMock * 4;
                int twoMock = count / 2;
                for (int j = 0; j < twoMock; j++) {
                    sb.append("BB");
                }
            }

            if (ch =='.') {
                sb.append(ch);
                count = 0;
            }
        }
        if (isPossible) {
            System.out.println(sb);
        }
    }
}
