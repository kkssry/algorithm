package baekjoon.q10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < count; i++) {
            String sentence = br.readLine();
            if (sentence.startsWith("push")) {
                stack.push(sentence.split(" ")[1]);
            }

            if (sentence.startsWith("top")) {
                if (stack.size() != 0) {
                    System.out.println(stack.peek());
                    continue;
                }
                System.out.println(-1);
            }

            if (sentence.startsWith("size")) {
                System.out.println(stack.size());
            }

            if (sentence.startsWith("empty")) {
                if (!stack.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(1);
            }

            if (sentence.startsWith("pop")) {
                if (stack.size() != 0) {
                    System.out.println(stack.pop());
                    continue;
                }
                System.out.println(-1);
            }
        }
    }
}
