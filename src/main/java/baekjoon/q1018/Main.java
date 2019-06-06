package baekjoon.q1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static private int startBlackcount = Integer.MAX_VALUE;
    static private int startWhiteCount = Integer.MAX_VALUE;
    static private String[][] blackStartChessBoard =
            {
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"}
            };

    static private String[][] whiteStartChessBoard =
            {
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"},
                    {"W", "B", "W", "B", "W", "B", "W", "B"},
                    {"B", "W", "B", "W", "B", "W", "B", "W"}

            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] rowAndColumn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] chessBoard = new String[rowAndColumn[0]][rowAndColumn[1]];
        initChessBoard(chessBoard, br);
        findRangeChessBoard(chessBoard);
        System.out.println(Math.min(startBlackcount, startWhiteCount));

    }

    private static void findRangeChessBoard(String[][] chessBoard) {
        int columnMaginotLine = chessBoard[0].length - 8;
        int rowMaginotLine = chessBoard.length - 8;

        for (int i = 0; i <= rowMaginotLine; i++) {
            for (int j = 0; j <= columnMaginotLine; j++) {
                startPosition(i, j, chessBoard);
            }
        }
    }

    private static void startPosition(int i, int j, String[][] chessBoard) {
        int blackCount = 0;
        int whiteCount = 0;

        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (!chessBoard[i + k][j + l].equals(blackStartChessBoard[k][l])) {
                    blackCount++;
                }
                if (!chessBoard[i + k][j + l].equals(whiteStartChessBoard[k][l])) {
                    whiteCount++;
                }
            }
        }

        if (startBlackcount > blackCount) {
            startBlackcount = blackCount;
        }

        if (startWhiteCount > whiteCount) {
            startWhiteCount = whiteCount;
        }
    }

    private static void initChessBoard(String[][] chessBoard, BufferedReader br) throws IOException {
        for (int i = 0; i < chessBoard.length; i++) {
            chessBoard[i] = br.readLine().split("");
        }
    }


}
