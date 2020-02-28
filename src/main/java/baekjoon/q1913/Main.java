package baekjoon.q1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int targetNumber = Integer.parseInt(br.readLine());

        int[][] board = new int[count][count];
        List<Integer> directionCounts = new ArrayList<>();
        initDirectionCounts(directionCounts, count);
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        initBoard(board, directionCounts, directions);
        int[] rowColumn = findTargetNumber(targetNumber, board);
        for (int[] ints : board) {
            System.out.println(Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        }
        System.out.println(Arrays.stream(rowColumn).mapToObj(String::valueOf).collect(Collectors.joining(" ")));

    }

    private static int[] findTargetNumber(int targetNumber, int[][] board) {
        int[] rowColumn = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == targetNumber) {
                    rowColumn[0] = i + 1;
                    rowColumn[1] = j + 1;
                    return rowColumn;
                }
            }
        }
        return rowColumn;
    }

    private static void initBoard(int[][] board, List<Integer> directionCounts, int[][] directions) {
        int startPoint = board.length / 2;
        int startNumber = 1;
        board[startPoint][startPoint] = startNumber;
        int x = startPoint;
        int y = startPoint;
        for (int i = 0; i < directionCounts.size(); i++) {
            int[] direction = directions[i % directions.length];
            for (int j = 0; j < directionCounts.get(i); j++) {
                x += direction[0];
                y += direction[1];
                board[x][y] = ++startNumber;
            }
        }

    }

    private static void initDirectionCounts(List<Integer> directionCounts, int count) {
        for (int i = 1; i < count; i++) {
            if (i == count - 1) {
                for (int j = 0; j < 3; j++) {
                    directionCounts.add(i);
                }
            } else {
                for (int j = 0; j < 2; j++) {
                    directionCounts.add(i);
                }
            }
        }
    }
}
