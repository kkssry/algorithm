package programmers.q1829;

import java.util.*;

public class Solution {
    private int[] rowDirection = {-1, 0, 1, 0};     // 북 동 남 서
    private int[] columnDirection = {0, 1, 0, -1};

    public int[] solution(int m, int n, int[][] picture) {
        Area[][] areas = new Area[picture.length][picture[0].length];
        initAreas(areas, picture);
        initIdentity(areas);
        int[] answer = new int[2];
        initAnswer1(answer, areas);
        initAnswer2(answer, areas);
        return answer;
    }

    private void initAnswer2(int[] answer, Area[][] areas) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (Area[] area : areas) {
            for (Area area1 : area) {
                if (area1.identity != 0) {
                    int identity = area1.identity;
                    map.put(identity, map.getOrDefault(identity, 0) + 1);
                }
            }
        }

        for (Integer integer : map.keySet()) {
            if (max < map.get(integer)) {
                max = map.get(integer);
            }
        }
        answer[1] = max;
    }

    private void initAnswer1(int[] answer, Area[][] areas) {
        Set<Integer> identifier = new HashSet<>();
        for (Area[] area : areas) {
            for (Area area1 : area) {
                if (area1.identity != 0) {
                    identifier.add(area1.identity);
                }
            }
        }
        answer[0] = identifier.size();
    }

    private void initIdentity(Area[][] areas) {
        int identity = 1;
        for (Area[] area : areas) {
            for (Area targetArea : area) {
                if (!targetArea.isChecked && targetArea.value != 0) {
                    targetArea.identity = identity;
                    startBFS(areas, targetArea);
                    identity++;
                }
            }
        }
    }

    private void startBFS(Area[][] areas, Area startArea) {
        Queue<Area> queue = new LinkedList<>();
        queue.add(startArea);
        while (!queue.isEmpty()) {
            Area currentArea = queue.poll();
            for (int i = 0; i < rowDirection.length; i++) {
                int row = currentArea.row + rowDirection[i];
                int column = currentArea.column + columnDirection[i];
                if (isMove(row, column, areas)) {
                    Area targetArea = areas[row][column];
                    if (currentArea.value != 0 && !targetArea.isChecked && currentArea.value == targetArea.value) {
                        targetArea.isChecked = true;
                        targetArea.identity = currentArea.identity;
                        queue.add(areas[row][column]);
                    }
                }
            }
        }
    }

    private boolean isMove(int row, int column, Area[][] areas) {
        return row >= 0 && row < areas.length && column >= 0 && column < areas[0].length;
    }

    private void initAreas(Area[][] areas, int[][] picture) {
        for (int i = 0; i < areas.length; i++) {
            for (int j = 0; j < areas[i].length; j++) {
                areas[i][j] = new Area(i, j, picture[i][j]);
            }
        }
    }

    static class Area {
        int identity;
        int row;
        int column;
        int value;
        boolean isChecked;

        Area(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}
