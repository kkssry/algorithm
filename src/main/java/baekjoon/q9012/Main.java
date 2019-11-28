package baekjoon.q9012;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            String[] arr = line.split("");
            String result = saveResult(arr);
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
    }

    private static String saveResult(String[] arr) {
        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("(")) {
                stack.push(s);
            } else {
                if (stack.size() == 0) {
                    return "NO";
                }
                stack.pop();
            }
        }

        if (stack.size() == 0) {
            return "YES";
        }
        return "NO";
    }
}
