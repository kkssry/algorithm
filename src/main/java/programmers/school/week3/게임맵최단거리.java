package programmers.school.week3;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class 게임맵최단거리 {
    Set<Integer> shortestPath = new TreeSet<>();

    public int solution(int[][] maps) {
        int answer = 0;

        boolean[][] bol = new boolean[maps.length][maps[0].length]; //왔던길 체크

        recursive(maps, 0, 0, bol, answer);
        for (int i = 0; i < bol.length; i++) {
            System.out.println(Arrays.toString(bol[i]));
        }

        System.out.println(shortestPath);
        if (shortestPath.isEmpty()) {
            return -1;
        }
        answer = shortestPath.iterator().next();

        return answer;
    }


    private void recursive(int[][] maps, int row, int column, boolean[][] bol, int answer) {

        if (row == maps.length - 1 && column == maps[0].length - 1) {
            answer++;
            shortestPath.add(answer);
            bol[row][column] = true;
        }

        if (maps[row][column] == 1 && !bol[row][column]) {
            answer++;
            bol[row][column] = true;

            if (row > 0) {
                if (maps[row - 1][column] == 1 && !bol[row - 1][column]) {    // 위
                    recursive(maps, row -1, column, bol, answer);
                }
            }

            if (column > 0) {
                if (maps[row][column - 1] == 1 && !bol[row][column - 1]) {    // 왼쪽
                    recursive(maps, row, column - 1, bol, answer);
                }
            }

            if (column < maps[0].length - 1) {
                if (maps[row][column + 1] == 1 && !bol[row][column + 1]) {     // 오른쪽
                    recursive(maps, row, column + 1, bol, answer);
                }
            }

            if (row < maps.length - 1) {
                if (maps[row + 1][column] == 1 && !bol[row + 1][column]) {   // 아래
                    recursive(maps, row + 1, column, bol, answer);
                }
            }


        }

        bol[row][column] = false;

    }
}



