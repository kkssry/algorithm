package baekjoon.q10989;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


/*
주석은 배열로 처리한거

입력 : Scanner -> BufferedReader
출력 : System.out.println -> BufferedWriter

 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        initMap(map);
        inputMapValue(map, count, br);
        printResult(map, bw);

//        int[] arr = new int[10001];
//        initArr(arr, count, br);
//        printResult(arr,bw);
    }

    private static void printResult(Map<Integer, Integer> map, BufferedWriter bw) throws IOException {
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < map.get(i); j++) {
                bw.write(Integer.toString(i));
                bw.newLine();
            }
        }
        bw.flush();
    }

    private static void inputMapValue(Map<Integer, Integer> map, int count, BufferedReader br) throws IOException {
        for (int i = 0; i < count; i++) {
            int key = Integer.parseInt(br.readLine());
            map.put(key, map.get(key) + 1);
        }
    }

    private static void initMap(Map<Integer, Integer> map) {
        for (int i = 1; i <= 10000; i++) {
            map.put(i, 0);
        }
    }

//    private static void printResult(int[] arr, BufferedWriter bw) throws IOException {
//        for (int i = 1; i <= 10000; i++) {
//            for (int j = 0; j < arr[i]; j++) {
//                bw.write(Integer.toString(i));
//                bw.newLine();
//            }
//        }
//        bw.flush();
//    }
//
//    private static void initArr(int[] arr, int count, BufferedReader br) throws IOException {
//        for (int i = 0; i < count; i++) {
//            int index = Integer.parseInt(br.readLine());
//            arr[index]++;
//        }
//    }

}
