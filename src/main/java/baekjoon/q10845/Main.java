package baekjoon.q10845;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue queue = new Queue(new LinkedList<>());
        startTest(queue, br, bw);
        bw.flush();
    }

    private static void startTest(Queue queue, BufferedReader br, BufferedWriter bw) throws IOException {
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String line = br.readLine();
            if (line.startsWith("push")) {
                queue.push(Integer.parseInt(line.split(" ")[1]));
            }
            if (line.equals("front")) {
                bw.write(queue.front() + "\n");
            }
            if (line.equals("back")) {
                bw.write(queue.back() + "\n");
            }
            if (line.equals("size")) {
                bw.write(queue.size() + "\n");
            }
            if (line.equals("pop")) {
                bw.write(queue.pop() + "\n");
            }
            if (line.equals("empty")) {
                bw.write(queue.empty() + "\n");
            }
        }
    }


    static class Queue {
        List<Integer> list;

        Queue(List<Integer> list) {
            this.list = list;
        }

         void push(int element) {
            list.add(element);
        }

         int pop() {
            if (!isEmpty()) {
                return list.remove(0);
            }
            return -1;
        }

        int back() {
            if (!isEmpty()) {
                return list.get(list.size() - 1);
            }
            return -1;
        }

        int front() {
            if (!isEmpty()) {
                return list.get(0);
            }
            return -1;
        }

         int size() {
            return list.size();
        }

        int empty() {
            return list.size() == 0 ? 1 : 0;
        }

        boolean isEmpty() {
            return list.isEmpty();
        }

    }
}
