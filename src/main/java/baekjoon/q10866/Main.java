package baekjoon.q10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        Deque<String> dq = new LinkedList<>();


        for (int i = 0; i < input; i++) {
            String[] arr = br.readLine().split(" ");
            if (arr.length == 2) {
                if (arr[0].equals("push_front")) {
                    dq.addFirst(arr[1]);
                } else {
                    dq.addLast(arr[1]);
                }
                continue;
            }

            if (arr[0].equals("pop_front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(dq.pollFirst());
                }
                continue;
            }

            if (arr[0].equals("pop_back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(dq.pollLast());
                }
                continue;
            }

            if (arr[0].equals("size")) {
                System.out.println(dq.size());
                continue;
            }

            if (arr[0].equals("empty")) {
                if (dq.isEmpty()) {
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
                continue;
            }

            if (arr[0].equals("front")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(dq.peekFirst());
                }
                continue;
            }

            if (arr[0].equals("back")) {
                if (dq.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(dq.peekLast());
                }
                continue;
            }
        }


    }
}
