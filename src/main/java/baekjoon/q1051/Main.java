package baekjoon.q1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int maxLength = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rowColum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] board = new int[rowColum[0]][rowColum[1]];
        initBoard(board, br);
        seekSquare(board);
        System.out.println((int) Math.pow(maxLength + 1, 2));
    }

    private static void seekSquare(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int min = Math.min(board.length - i - 1, board[0].length - j - 1);
                fromTheBigOne(i, j, board, min);
            }
        }
    }

    private static void fromTheBigOne(int i, int j, int[][] board, int min) {
        for (int k = min; k >= 0; k--) {
            if (maxLength < k && isSquare(i, j, board, k)) {
                maxLength = k;
                return;
            }
        }
    }

    private static boolean isSquare(int i, int j, int[][] board, int interval) {
        return board[i][j] == board[i + interval][j]
                && board[i][j + interval] == board[i + interval][j + interval]
                && board[i][j] == board[i][j + interval];
    }

    private static void initBoard(int[][] board, BufferedReader br) throws IOException {
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
