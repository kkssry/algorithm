package baekjoon.q4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int i = 1;
        List<String> list = new ArrayList<>();
        while (!(line = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            initStack(line, stack, i, list);
            ++i;
        }
        list.forEach(System.out::println);
    }

    private static void initStack(String line, Stack<Character> stack, int index, List<String> list) {
        for (int i = 0; i < line.length(); i++) {
            char word = line.charAt(i);
            if (word == '(' || word == '[') {
                stack.push(word);
            }
            if (word == ')') {
                judgeNo(stack, '(', list);
                if (listSizeCheck(index, list)) break;
            }
            if (word == ']') {
                judgeNo(stack, '[', list);
                if (listSizeCheck(index, list)) break;
            }
        }
        if (listSizeCheck(index, list)) return;
        if (stack.isEmpty()) {
            list.add("yes");
        } else {
            list.add("no");
        }
    }

    private static boolean listSizeCheck(int index, List<String> list) {
        return list.size() == index;
    }

    private static void judgeNo(Stack<Character> stack, char word, List<String> list) {
        if (!stack.isEmpty() && stack.peek() == word) {
            stack.pop();
            return;
        }
        list.add("no");
    }
}
