package baekjoon.q1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        initList(list, Integer.parseInt(inputs[0]));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        saveResult(arr, list);
    }

    private static void saveResult(int[] arr, List<Integer> list) {
        int answer = 0;
        for (int target : arr) {
            int front = initFront(list, target);
            int back = list.size() - front;

            if (front <= back) {
                moveBackToFront(back, list);
            } else {
                moveFrontToBack(front, list);
            }
            
            list.remove(0);
            answer += Math.min(front, back);
        }
        System.out.println(answer);
    }

    private static void moveFrontToBack(int front, List<Integer> list) {
        for (int j = 0; j < front; j++) {
            list.add(list.remove(0));
        }
    }

    private static void moveBackToFront(int back, List<Integer> list) {
        for (int j = 0; j < back; j++) {
            list.add(0, list.remove(list.size() - 1));
        }
    }

    private static int initFront(List<Integer> list, int target) {
        int front = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == target) {
                front = j;
            }
        }
        return front;
    }

    private static void initList(List<Integer> list, int EndNum) {
        for (int i = 1; i <= EndNum; i++) {
            list.add(i);
        }
    }
}
