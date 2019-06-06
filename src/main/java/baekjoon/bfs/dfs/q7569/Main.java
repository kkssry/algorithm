package baekjoon.bfs.dfs.q7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int count = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boxSize = new int[3];
        initBoxSize(boxSize, br);
        int[][][] boxes = new int[boxSize[2]][boxSize[1]][boxSize[0]];      // 높이 , 행 , 열
        initBoxes(boxes, br);
        calculateRipeTomato(boxes);
        checkUnripeTomato(boxes);
        System.out.println(count);
    }

    private static void checkUnripeTomato(int[][][] boxes) {
        loop : for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                for (int k = 0; k < boxes[i][j].length; k++) {
                    if (boxes[i][j][k] == 0) {
                        count = -1;
                        break loop;
                    }
                }
            }
        }
    }

    private static void calculateRipeTomato(int[][][] boxes) {
        Queue<Tomato> tomatoes = new LinkedList<>();
        findRipeTomato(tomatoes, boxes);

        while (!tomatoes.isEmpty()) {
            Tomato tomato = tomatoes.poll();

            if (tomato.row > 0 && boxes[tomato.floor][tomato.row - 1][tomato.column] == 0) {
                boxes[tomato.floor][tomato.row - 1][tomato.column] = 1;
                tomatoes.offer(new Tomato(tomato.floor, tomato.row - 1, tomato.column, tomato.count + 1));
            }

            if (tomato.column < boxes[0][0].length - 1 && boxes[tomato.floor][tomato.row][tomato.column + 1] == 0) {
                boxes[tomato.floor][tomato.row][tomato.column + 1] = 1;
                tomatoes.offer(new Tomato(tomato.floor, tomato.row, tomato.column + 1, tomato.count + 1));
            }

            if (tomato.row < boxes[0].length - 1 && boxes[tomato.floor][tomato.row + 1][tomato.column] == 0) {
                boxes[tomato.floor][tomato.row + 1][tomato.column] = 1;
                tomatoes.offer(new Tomato(tomato.floor, tomato.row + 1, tomato.column, tomato.count + 1));
            }

            if (tomato.column > 0 && boxes[tomato.floor][tomato.row][tomato.column - 1] == 0) {
                boxes[tomato.floor][tomato.row][tomato.column - 1] = 1;
                tomatoes.offer(new Tomato(tomato.floor, tomato.row, tomato.column - 1, tomato.count + 1));
            }

            if (tomato.floor > 0) {         //0보다 크면 위로 확장 시킬수 있따.
                if (boxes[tomato.floor - 1][tomato.row][tomato.column] == 0) {
                    boxes[tomato.floor - 1][tomato.row][tomato.column] = 1;
                    tomatoes.offer(new Tomato(tomato.floor - 1, tomato.row, tomato.column, tomato.count + 1));
                }
            }

            if (tomato.floor < boxes.length - 1) {      //박스크기 보다 작으면 아래로 확장 시킬수 있다.
                if (boxes[tomato.floor + 1][tomato.row][tomato.column] == 0) {
                    boxes[tomato.floor + 1][tomato.row][tomato.column] = 1;
                    tomatoes.offer(new Tomato(tomato.floor + 1, tomato.row, tomato.column, tomato.count + 1));
                }
            }

            if (count < tomato.count) {
                count = tomato.count;
            }
        }
    }

    private static void findRipeTomato(Queue<Tomato> tomatoes, int[][][] boxes) {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                for (int k = 0; k < boxes[i][j].length; k++) {
                    if (boxes[i][j][k] == 1) {
                        tomatoes.offer(new Tomato(i, j, k, 0));
                    }
                }
            }
        }
    }

    private static void initBoxes(int[][][] boxes, BufferedReader br) throws IOException {
        for (int i = 0; i < boxes.length; i++) {
            for (int j = 0; j < boxes[i].length; j++) {
                boxes[i][j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }
    }

    private static void initBoxSize(int[] boxSize, BufferedReader br) throws IOException {
        int[] sizes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.arraycopy(sizes, 0, boxSize, 0, sizes.length);
    }

    static class Tomato {
        int floor;
        int row;
        int column;
        int count;

        public Tomato(int floor, int row, int column, int count) {
            this.floor = floor;
            this.row = row;
            this.column = column;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Tomato{" +
                    "floor=" + floor +
                    ", row=" + row +
                    ", column=" + column +
                    ", count=" + count +
                    '}';
        }
    }
}
