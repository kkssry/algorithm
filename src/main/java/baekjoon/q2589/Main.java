package baekjoon.q2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static boolean[][] checkMap;
    private static int finalCorrecnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String[][] map = mapInit(arr, br);
        checkMap = new boolean[arr[0]][arr[1]];
        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("L")) {
                    checkMap[i][j] = false;
                    queue.add(new Point(i, j, 0));
                    makeCheckMap(arr, map);
                    calculateMinimumPath(arr, queue);
                }
            }
        }
        System.out.println(finalCorrecnt);
    }

    private static void calculateMinimumPath(int[] arr, Queue<Point> queue) {
        int value = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            value = point.value;

            if (point.row > 0 && checkMap[point.row - 1][point.column]) {
                checkMap[point.row - 1][point.column] = false;
                queue.add(new Point(point.row - 1, point.column, value + 1));
            }

            if (point.column < arr[1] - 1 && checkMap[point.row][point.column + 1]) {
                checkMap[point.row][point.column + 1] = false;
                queue.add(new Point(point.row, point.column + 1, value + 1));
            }

            if (point.row < arr[0] - 1 && checkMap[point.row + 1][point.column]) {
                checkMap[point.row + 1][point.column] = false;
                queue.add(new Point(point.row + 1, point.column, value + 1));
            }

            if (point.column > 0 && checkMap[point.row][point.column - 1]) {
                checkMap[point.row][point.column - 1] = false;
                queue.add(new Point(point.row, point.column - 1, value + 1));
            }
        }


        if (finalCorrecnt < value) {
            finalCorrecnt = value;
        }

    }

    private static void makeCheckMap(int[] arr, String[][] map) {
        for (int i = 0; i < arr[0]; i++) {
            for (int j = 0; j < arr[1]; j++) {
                if (map[i][j].equals("L")) {
                    checkMap[i][j] = true;
                }
            }
        }
    }

    private static String[][] mapInit(int[] arr, BufferedReader br) throws IOException {
        String[][]map = new String[arr[0]][arr[1]];
        for (int i = 0; i < map.length; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).toArray(String[]::new);
        }
        return map;
    }

    static class Point {
        int row;
        int column;
        int value;

        public Point(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
