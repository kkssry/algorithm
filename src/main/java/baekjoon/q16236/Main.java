package baekjoon.q16236;

import java.util.*;

public class Main {
    private static int time = 0;
    private static int startRow;
    private static int startColumn;
    private static int babySharkLevel = 2;
    private static int babySharkExperience = 0;

    private static int[] rowDirection = {-1, 0, 0, 1};          // 북 서 동 남
    private static int[] columnDirection = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Space[][] space = new Space[size][size];
        initSpace(space, sc);
        startHunting(space);
        System.out.println(time);
    }

    private static void initSpace(Space[][] space, Scanner sc) {
        for (int i = 0; i < space.length; i++) {
            for (int j = 0; j < space[i].length; j++) {
                int level = sc.nextInt();
                if (level == 9) {
                    startRow = i;
                    startColumn = j;
                    level = 0;
                }
                space[i][j] = new Space(i, j, level);
            }
        }
    }

    private static void startHunting(Space[][] space) {
        while (true) {
            Space maybeSpace = seekPrey(space);
            if (maybeSpace == null) {
                break;
            }
            updateBabySharkAndSpaceStatus(maybeSpace, space);
        }
    }

    private static Space seekPrey(Space[][] space) {
        Queue<Space> queue = new LinkedList<>();
        PriorityQueue<Space> priorityQueue = new PriorityQueue<>();
        space[startRow][startColumn].isChecked = true;
        space[startRow][startColumn].count = 0;
        queue.add(space[startRow][startColumn]);
        while (!queue.isEmpty()) {
            Space currentSpace = queue.poll();
            if (currentSpace.level < babySharkLevel && currentSpace.level > 0) {
                priorityQueue.add(currentSpace);
            }
            for (int i = 0; i < rowDirection.length; i++) {
                int row = currentSpace.row + rowDirection[i];
                int column = currentSpace.column + columnDirection[i];
                if (isMove(row, column, space.length) && !space[row][column].isChecked) {
                    if (space[row][column].level <= babySharkLevel) {
                        space[row][column].isChecked = true;
                        space[row][column].count = currentSpace.count + 1;
                        queue.add(space[row][column]);
                    }
                }
            }
        }
        return priorityQueue.poll();
    }

    private static boolean isMove(int row, int column, int limitSize) {
        return row >= 0 && row < limitSize && column >= 0 && column < limitSize;
    }

    private static void updateBabySharkAndSpaceStatus(Space maybeSpace, Space[][] space) {
        babySharkExperience++;
        if (babySharkExperience == babySharkLevel) {
            babySharkExperience = 0;
            babySharkLevel++;
        }
        time += maybeSpace.count;
        initIsCheckedAndCount(space);
        startRow = maybeSpace.row;
        startColumn = maybeSpace.column;
        space[maybeSpace.row][maybeSpace.column].level = 0;
        space[maybeSpace.row][maybeSpace.column].isChecked = true;
    }

    private static void initIsCheckedAndCount(Space[][] space) {
        for (Space[] spaces : space) {
            for (Space space1 : spaces) {
                space1.isChecked = false;
                space1.count = 0;
            }
        }
    }

    static class Space implements Comparable<Space> {
        int row;
        int column;
        int level;
        int count;
        boolean isChecked;

        Space(int row, int column, int level) {
            this.row = row;
            this.column = column;
            this.level = level;
        }

        @Override
        public String toString() {
            return "Space{" +
                    "count=" + count +
                    '}';
        }

        @Override
        public int compareTo(Space o) {
            if (count == o.count) {
                if (row == o.row) {
                    return Integer.compare(column, o.column);
                }
                return Integer.compare(row, o.row);
            }
            return Integer.compare(count, o.count);
        }
    }
}

