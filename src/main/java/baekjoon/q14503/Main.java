package baekjoon.q14503;

import java.util.*;

public class Main {
    private static int[] directionsX = {0, -1, 0, 1}; // 북 서 남 동 (x축)
    private static int[] directionsY = {-1, 0, 1, 0}; // 북 서 남 동 (y축)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowCount = sc.nextInt();
        int columnCount = sc.nextInt();

        int fromNorth = sc.nextInt();
        int fromWest = sc.nextInt();
        int inputDirection = sc.nextInt();
        int direction = calculateDirection(inputDirection);

        Space[][] room = new Space[rowCount][columnCount];
        initRoom(room, sc);
        Robot firstRobot = new Robot(fromNorth, fromWest, direction);
        startCleaning(room, firstRobot);
    }

    private static int calculateDirection(int inputDirection) {
        if (inputDirection == 0) {
            return 0;
        }
        if (inputDirection == 1) {
            return 3;
        }
        if (inputDirection == 2) {
            return 2;
        }
        return 1;
    }

    private static void startCleaning(Space[][] room, Robot firstRobot) {
        int count = 0;
        Queue<Robot> queue = new LinkedList<>();
        queue.add(firstRobot);
        while (!queue.isEmpty()) {
            Robot robot = queue.poll();
            int fromNorth = robot.fromNorth;
            int fromWest = robot.fromWest;

            if (!room[fromNorth][fromWest].isChecked) {
                room[fromNorth][fromWest].isChecked = true;
                count++;
            }

            int count1 = checkClean(room, robot, queue);
            if (count1 > 0) {
                continue;
            }

            checkRear(room, robot, fromNorth, fromWest, queue);
        }

        System.out.println(count);
    }

    private static void checkRear(Space[][] room, Robot robot, int fromNorth, int fromWest, Queue<Robot> queue) {
        int direction = (robot.direction + 2) % 4;
        int upDownRear = fromNorth + directionsY[direction];
        int rightLeftRear = fromWest + directionsX[direction];

        if (isMove(room, upDownRear, rightLeftRear) && !room[upDownRear][rightLeftRear].isWall) {
            Robot newRobot = new Robot(upDownRear, rightLeftRear, robot.direction);
            int count = checkClean(room, newRobot, queue);
            if (count > 0) {
                return;
            }
            queue.add(newRobot);
        }
    }

    private static int checkClean(Space[][] room, Robot robot, Queue<Robot> queue) {
        int count = 0;

        for (int i = 0; i < directionsX.length; i++) {
            int direction = (robot.direction + i + 1) % 4;
            int nextupDown = robot.fromNorth + directionsY[direction];
            int nextRightLeft = robot.fromWest + directionsX[direction];

            if (isMove(room, nextupDown, nextRightLeft) && !room[nextupDown][nextRightLeft].isWall && !room[nextupDown][nextRightLeft].isChecked) {
                Robot newRobot = new Robot(nextupDown, nextRightLeft, direction);
                queue.add(newRobot);
                count++;
                break;
            }
        }
        return count;
    }

    private static boolean isMove(Space[][] room, int nextupDown, int nextRightLeft) {
        return nextRightLeft < room[0].length && nextRightLeft >= 0 && nextupDown >= 0 && nextupDown < room.length;
    }

    private static void initRoom(Space[][] room, Scanner sc) {
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                boolean iswall = sc.nextInt() == 1;
                room[i][j] = new Space(i, j, iswall, false);
            }
        }
    }

    static class Space {
        int fromNorth;
        int fromWest;
        boolean isChecked;
        boolean isWall;

        Space(int fromNorth, int getFromNorth, boolean isWall, boolean isChecked) {
            this.fromNorth = fromNorth;
            this.fromWest = getFromNorth;
            this.isWall = isWall;
            this.isChecked = isChecked;
        }

        @Override
        public String toString() {
            return isChecked ? "1" : "0";
        }
    }

    static class Robot {
        int fromNorth;
        int fromWest;
        int direction;

        Robot(int fromNorth, int fromEast, int direction) {
            this.fromNorth = fromNorth;
            this.fromWest = fromEast;
            this.direction = direction;
        }

        @Override
        public String toString() {
            return "Robot{" +
                    "fromNorth=" + fromNorth +
                    ", fromWest=" + fromWest +
                    ", direction=" + direction +
                    '}';
        }
    }
}
