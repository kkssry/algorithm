package baekjoon.bfs.dfs.q7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//scanner로 입력값받기 2 4 일때 2,4 따로 받을 수 있다?

public class Main {
    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] boxSize = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] box = new int[boxSize[1]][boxSize[0]];

        initBox(box, br);
        Queue<Tomato> queue = new LinkedList<>();
        findRipeTomato(box, queue);
        calculateAllRipeTomatoDays(box, queue);
        checkAllTomatoRipe(box);
        System.out.println(days);
    }

    private static void checkAllTomatoRipe(int[][] box) {
        int unripeCount = 0;

        for (int[] box1 : box) {
            for (int i : box1) {
                if (i == 0) {
                    unripeCount++;
                }
            }
        }

        if (unripeCount > 0) {
            days = -1;
        }
    }

    private static void calculateAllRipeTomatoDays(int[][] box, Queue<Tomato> queue) {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            if (tomato.row > 0 && box[tomato.row - 1][tomato.column] == 0) {      //위
                box[tomato.row - 1][tomato.column] = 1;
                queue.add(new Tomato(tomato.row - 1, tomato.column, tomato.days + 1));
            }

            if (tomato.column < box[0].length - 1 && box[tomato.row][tomato.column + 1] == 0) {      //오른쪽
                box[tomato.row][tomato.column + 1] = 1;
                queue.add(new Tomato(tomato.row, tomato.column + 1, tomato.days + 1));
            }


            if (tomato.row < (box.length - 1) && box[tomato.row + 1][tomato.column] == 0) {      //아래
                box[tomato.row + 1][tomato.column] = 1;
                queue.add(new Tomato(tomato.row + 1, tomato.column, tomato.days + 1));
            }

            if (tomato.column > 0 && box[tomato.row][tomato.column - 1] == 0) {      //왼쪽
                box[tomato.row][tomato.column - 1] = 1;
                queue.add(new Tomato(tomato.row, tomato.column - 1, tomato.days + 1));
            }
            days = tomato.days;
        }
    }

    private static void findRipeTomato(int[][] box, Queue<Tomato> queue) {
        loop : for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[i].length; j++) {
                if (box[i][j] == 1) {
                    queue.add(new Tomato(i,j,0));
                }
            }
        }
    }

    private static void initBox(int[][] box, BufferedReader br) throws IOException {
        for (int i = 0; i < box.length; i++) {
            box[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    static class Tomato {
        int row;
        int column;
        int days;

        public Tomato(int row, int column, int days) {
            this.row = row;
            this.column = column;
            this.days = days;
        }
    }
}
