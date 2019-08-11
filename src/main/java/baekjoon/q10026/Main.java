package baekjoon.q10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] rowDirection = {-1, 0, 1, 0};           // 북 동 남 서
    private static int[] coloumDirection = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] results = new int[2];
        int size = Integer.parseInt(br.readLine());
        Color[][] colorBoard = new Color[size][size];
        initColorBoard(colorBoard, br);
        countSection(colorBoard);
        results[0] = identityCount(colorBoard);
        setExclusiveBlindColorBoard(colorBoard);
        countSection(colorBoard);
        results[1] = identityCount(colorBoard);
        System.out.println(results[0] + " " + results[1]);
    }

    private static void setExclusiveBlindColorBoard(Color[][] colorBoard) {
        for (Color[] colors : colorBoard) {
            for (Color color : colors) {
                color.isChecked = false;
                if (color.name.equals("G")) {
                    color.name = "R";
                }
            }
        }
    }

    private static int identityCount(Color[][] colorBoard) {
        Set<Integer> countIdentity = new HashSet<>();
        for (Color[] colors : colorBoard) {
            for (Color color : colors) {
                countIdentity.add(color.identity);
            }
        }
        return countIdentity.size();
    }

    private static void countSection(Color[][] colorBoard) {
        int identity = 0;
        for (Color[] colors : colorBoard) {
            for (Color color : colors) {
                if (!color.isChecked) {
                    bfs(color, colorBoard, identity);
                    identity++;
                }
            }
        }
    }

    private static void bfs(Color color, Color[][] colorBoard, int identity) {
        Queue<Color> queue = new LinkedList<>();
        color.isChecked = true;
        color.identity = identity;
        queue.add(color);
        while (!queue.isEmpty()) {
            Color currentColor = queue.poll();
            for (int i = 0; i < rowDirection.length; i++) {
                int row = currentColor.row + rowDirection[i];
                int column = currentColor.column + coloumDirection[i];
                if (isMove(row, column, colorBoard.length)) {
                    Color targetColor = colorBoard[row][column];
                    if (currentColor.name.equals(targetColor.name) && !targetColor.isChecked) {
                        targetColor.isChecked = true;
                        targetColor.identity = currentColor.identity;
                        queue.add(targetColor);
                    }
                }
            }
        }
    }

    private static boolean isMove(int row, int column, int endLength) {
        return row >=0 && row < endLength  && column >= 0 && column < endLength;
    }

    private static void initColorBoard(Color[][] colorBoard, BufferedReader br) throws IOException {
        for (int i = 0; i < colorBoard.length; i++) {
            String[] colors = br.readLine().split("");
            for (int j = 0; j < colorBoard[i].length; j++) {
                colorBoard[i][j] = new Color(i, j, colors[j]);
            }
        }
    }

    static class Color {
        int row;
        int column;
        String name;
        int identity;
        boolean isChecked;

        Color(int row, int column, String name) {
            this.row = row;
            this.column = column;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    ", identity=" + identity +
                    '}';
        }
    }

}
