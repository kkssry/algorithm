package baekjoon.q11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        int chunk = problem.length() / 10;
        int rest = problem.length() % 10;

        if (rest > 0) {
            chunk += 1;
        }

        for (int i = 0; i < chunk; i++) {
            if (i == chunk - 1 && rest > 0) {
                System.out.println(problem.substring(i*10, (i*10) + rest));
                return;
            }
            System.out.println(problem.substring((i*10),10*(i+1)));

        }

    }
}
