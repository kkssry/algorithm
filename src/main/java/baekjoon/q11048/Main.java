package baekjoon.q11048;

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
        firstLineSetting(board);
        firstColumnSetting(board);
        saveResult(board);
        System.out.println(board[rowColumn[0] - 1][rowColumn[1] - 1]);
    }

    private static void saveResult(int[][] board) {
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                board[i][j] += Math.max(board[i - 1][j], board[i][j-1]);
            }
        }
    }

    private static void firstColumnSetting(int[][] board) {
        for (int i = 1; i < board.length; i++) {
            board[i][0] += board[i - 1][0];
        }
    }

    private static void firstLineSetting(int[][] board) {
        for (int i = 1; i < board[0].length; i++) {
            board[0][i] += board[0][i-1];
        }
    }

    private static void initBoard(int[][] board, BufferedReader br) throws IOException {
        for (int i = 0; i < board.length; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

}
