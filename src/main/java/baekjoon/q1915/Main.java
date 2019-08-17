package baekjoon.q1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rowColumn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[rowColumn[0]][rowColumn[1]];
        initBoard(board, br);
        startDP(board);
        int a = Arrays.stream(board).flatMapToInt(Arrays::stream).max().getAsInt();
        System.out.println((int)Math.pow(a,2));
    }

    private static void startDP(int[][] board) {
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1])) + 1;
            }
        }
    }

    private static void initBoard(int[][] board, BufferedReader br) throws IOException {
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
