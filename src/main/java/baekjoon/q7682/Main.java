package baekjoon.q7682;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while (!(line = br.readLine()).equals("end")) {
            String[][] board = new String[3][3];
            String[] arr = line.split("");
            initBoard(board, arr);
            int countX = checkCountXOrO(board, "X");
            int countO = checkCountXOrO(board, "O");

            if (!isValidFirstCondition(countX, countO)) {
                bw.write("invalid\n");
                continue;
            }
            isVictoryOrDefeat(board, countX, countO, bw);
        }
        bw.flush();
    }


    private static void isVictoryOrDefeat(String[][] words, int countX, int countO, BufferedWriter bw) throws IOException {
        boolean isXWin = judgeWinner(words, "X");
        boolean isOWin = judgeWinner(words, "O");

        if (countX == 3 && countO == 2 && isXWin) {
            bw.write("valid\n");
            return;
        }
        if (countX == 3 && countO == 3 && isOWin) {
            bw.write("valid\n");
            return;
        }
        if (countX == 4 && countO == 3 && isXWin) {
            bw.write("valid\n");
            return;
        }
        if (countX == 4 && countO == 4 && isOWin) {
            bw.write("valid\n");
            return;
        }
        if (countX == 5 && countO == 4) {
            if (isOWin) {
                bw.write("invalid\n");
            } else {
                bw.write("valid\n");
            }
            return;
        }
        bw.write("invalid\n");
    }

    private static boolean judgeWinner(String[][] words, String xo) {
        if (words[0][0].equals(xo)) {
            if (words[0][1].equals(xo) && words[0][2].equals(xo)) {
                return true;
            }
            if (words[1][0].equals(xo) && words[2][0].equals(xo)) {
                return true;
            }
            if (words[1][1].equals(xo) && words[2][2].equals(xo)) {
                return true;
            }
        }

        if (words[0][1].equals(xo) && words[1][1].equals(xo) && words[2][1].equals(xo)) {
            return true;
        }

        if (words[1][0].equals(xo) && words[1][1].equals(xo) && words[1][2].equals(xo)) {
            return true;
        }

        if (words[2][0].equals(xo) && words[2][1].equals(xo) && words[2][2].equals(xo)) {
            return true;
        }

        if (words[0][2].equals(xo)) {
            if (words[1][1].equals(xo) && words[2][0].equals(xo)) {
                return true;
            }
            return words[1][2].equals(xo) && words[2][2].equals(xo);
        }

        return false;
    }


    private static boolean isValidFirstCondition(int countX, int countO) {
        return (countX == 3 && countO == 2) ||
                (countX == 3 && countO == 3) ||
                (countX == 4 && countO == 3) ||
                (countX == 4 && countO == 4) ||
                (countX == 5 && countO == 4);
    }

    private static int checkCountXOrO(String[][] board, String xo) {
        int count = 0;
        for (String[] strings : board) {
            for (String string : strings) {
                if (string.equals(xo)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void initBoard(String[][] board, String[] arr) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = arr[i * 3 + j];
            }
        }
    }

}
