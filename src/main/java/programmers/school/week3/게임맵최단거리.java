package programmers.school.week3;

import java.util.*;

public class 게임맵최단거리 {

    public int solution(int[][] maps) {
        int answer = 0;
        List<Integer> shortestPath = new LinkedList<>();

        Stack<Integer> stack = new Stack<>();

        int mapColumn = maps.length;
        int mapRow = maps[0].length;

        Direction[] directions = new Direction[4];
        directions[0] = new Direction(1, 0);     //북
        directions[1] = new Direction(0, 1);     //동
        directions[2] = new Direction(-1, 0);    //남
        directions[3] = new Direction(0, -1);    //서

        boolean[][] bol = new boolean[maps.length][maps[0].length]; //왔던길 체크

//        recursive(maps, 0, 0, bol, answer);

        int initDir = 0;

        Direction cur = new Direction(0, 0);
        while (true) {
            if (cur.x == maps.length - 1 && cur.y == maps[0].length - 1) {
                shortestPath.add(stack.size());
                break;
            }

            boolean forwarded = false;
            for (int dir = initDir; dir < 4; dir++) {
                if (movable(cur, dir, mapColumn, mapRow)) {


                }
            }

        }


        if (shortestPath.isEmpty()) {
            return -1;
        }
        answer = Collections.min(shortestPath);

        return answer;
    }

    private boolean movable(Direction cur, int dir, int mapColumn, int mapRow) {
        if (cur.x == 0 && dir == 0) {         // 위쪽 벽 일때 북쪽으로 못감
            return false;
        }

        if (cur.y == mapRow -1 && dir == 1) {       //동쪽 벽일때 동쪽으로 못감
            return  false;
        }

        if (cur.x == mapColumn - 1 && dir == 2) {       //남쪽 벽일때 남쪽으로 못감
            return false;
        }

        if (cur.y == 0 && dir == 3) {         // 서쪽 벽 일때 서쪽으로 못감
            return false;
        }

        return true;
    }


//    private void recursive(int[][] maps, int row, int column, boolean[][] bol, int answer) {
//        if (row == maps.length - 1 && column == maps[0].length - 1) {
//            answer++;
//            shortestPath.add(answer);
//            bol[row][column] = true;
//        }
//
//        if (maps[row][column] == 1 && !bol[row][column]) {
//            answer++;
//            bol[row][column] = true;
//
//            if (row < maps.length - 1) {
//                if (maps[row + 1][column] == 1 && !bol[row + 1][column]) {   // 아래
//                    recursive(maps, row + 1, column, bol, answer);
//                }
//            }
//
//            if (row > 0) {
//                if (maps[row - 1][column] == 1 && !bol[row - 1][column]) {    // 위
//                    recursive(maps, row -1, column, bol, answer);
//                }
//            }
//
//            if (column < maps[0].length - 1) {
//                if (maps[row][column + 1] == 1 && !bol[row][column + 1]) {     // 오른쪽
//                    recursive(maps, row, column + 1, bol, answer);
//                }
//            }
//
//
//            if (column > 0) {
//                if (maps[row][column - 1] == 1 && !bol[row][column - 1]) {    // 왼쪽
//                    recursive(maps, row, column - 1, bol, answer);
//                }
//            }
//
//        }
//
//        bol[row][column] = false;
//
//    }
}

class Direction {
    int x;
    int y;

    public Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
}






