package baekjoon.q1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int[] rowDirection = {-1, 0, 1, 0};      // 북 동 남 서
    private static int[] columnDirection = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sizes = br.readLine().split(" ");

        int rowCount = Integer.parseInt(sizes[1]);
        int columnCount = Integer.parseInt(sizes[0]);
        Can[][] cans = new Can[rowCount][columnCount];
        initRowAndColumn(cans);
        initValue(cans);


        initCans(cans, br);


    }

    private static void initValue(Can[][] cans) {
        Queue<Can> queue = new LinkedList<>();
        cans[0][0].isChecked = true;
        queue.add(cans[0][0]);
        while (!queue.isEmpty()) {
            Can currentCan = queue.poll();
            for (int i = 0; i < rowDirection.length; i++) {
                int row = currentCan.row + rowDirection[i];
                int column = currentCan.column + columnDirection[i];
                if (isMove(row, column, cans)) {
                    Can targetCan = cans[row][column];
                    if (!targetCan.isChecked) {
                        targetCan.value = currentCan.value - 1;
                        targetCan.isChecked = true;
                        queue.add(targetCan);
                    }
                }
            }
        }
    }

    private static boolean isMove(int row, int column, Can[][] cans) {
        return row >= 0 && row < cans.length && column >= 0 && column < cans[0].length;
    }

    private static void initRowAndColumn(Can[][] cans) {
        for (int i = 0; i < cans.length; i++) {
            for (int j = 0; j < cans[i].length; j++) {
                cans[i][j] = new Can(i, j);
            }
        }
    }

    private static void initCans(Can[][] cans, BufferedReader br) throws IOException {
        for (Can[] can : cans) {
            int[] values = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < can.length; j++) {
                if (values[j] == 0) {
                    can[j].value = Integer.MIN_VALUE;
                }
            }
        }
    }

    static class Can {
        int row;
        int column;
        int value;
        boolean isChecked;
        boolean isDestroyed;

        Can(int row, int column) {
            this.row = row;
            this.column = column;
        }

        Can(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value +" ";
        }
    }

}
