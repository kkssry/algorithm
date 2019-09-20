package baekjoon.q14502;

import java.util.*;

public class Main {
    private static int maxSafeCount = 0;

    private static int[] upDown = {-1, 0, 1, 0};             // 북 동 남 서
    private static int[] rightLeft = {0, 1, 0, -1};          // 북 동 남 서

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fromNorth = sc.nextInt();
        int fromWest = sc.nextInt();
        Point[][] points = new Point[fromNorth][fromWest];
        initPoints(points, sc);
        Point[][] copyInitPoints = initCopyPoints(points);

        int[] emptySpaceAndVirusCount = new int[2];
        countEmptySpaceAndVirus(emptySpaceAndVirusCount, points);
        Point[][] emptySpaceAndVirusSpace = new Point[2][];
        initSizeEmptySpaceAndVirusSpace(emptySpaceAndVirusSpace, emptySpaceAndVirusCount);
        initEmptySpaceAndVirusSpace(emptySpaceAndVirusSpace, points, copyInitPoints);

        construcWallFromEmptySpace(points, emptySpaceAndVirusSpace, copyInitPoints);
        System.out.println(maxSafeCount);
    }

    private static Point[][] initCopyPoints(Point[][] points) {
        Point[][] copyInitPoints = new Point[points.length][points[0].length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                Point copyPoint = points[i][j];
                copyInitPoints[i][j] = new Point(copyPoint.fromNorth, copyPoint.fronWest, copyPoint.value);
            }
        }
        return copyInitPoints;
    }


    private static void initSizeEmptySpaceAndVirusSpace(Point[][] emptySpaceAndVirusSpace, int[] emptySpaceAndVirusCount) {
        for (int i = 0; i < emptySpaceAndVirusSpace.length; i++) {
            emptySpaceAndVirusSpace[i] = new Point[emptySpaceAndVirusCount[i]];
        }
    }


    private static void construcWallFromEmptySpace(Point[][] points, Point[][] emptySpaceAndVirusSpace, Point[][] copyInitPoints) {
        for (int i = 0; i < emptySpaceAndVirusSpace[0].length - 2; i++) {
            for (int j = i + 1; j < emptySpaceAndVirusSpace[0].length - 1; j++) {
                for (int k = j + 1; k < emptySpaceAndVirusSpace[0].length; k++) {
                    constructWall(points, emptySpaceAndVirusSpace[0][i], emptySpaceAndVirusSpace[0][j], emptySpaceAndVirusSpace[0][k]);
                    spreadVirus(points, emptySpaceAndVirusSpace);
                    countSurvivor(points);
                    points = initCopyPoints(copyInitPoints);
                }
            }
        }
    }

    private static void countSurvivor(Point[][] points) {
        int count = 0;
        for (Point[] point : points) {
            for (Point p : point) {
                if (p.value == 0) {
                    count++;
                }
            }
        }
        if (maxSafeCount < count) {
            maxSafeCount = count;
        }
    }

    private static void spreadVirus(Point[][] points, Point[][] emptySpaceAndVirusSpace) {
        Queue<Point> virusPoints = new LinkedList<>();
        Collections.addAll(virusPoints, emptySpaceAndVirusSpace[1]);

        while (!virusPoints.isEmpty()) {
            Point virusPoint = virusPoints.poll();
            int fromNorth = virusPoint.fromNorth;
            int fromWest = virusPoint.fronWest;

            for (int i = 0; i < upDown.length; i++) {
                int updown = fromNorth + upDown[i];
                int rightLeft1 = fromWest + rightLeft[i];
                if (isMove(updown, rightLeft1, points)) {
                    Point targetPoint = points[updown][rightLeft1];
                    if (!targetPoint.isChecked && targetPoint.value == 0) {
                        targetPoint.value = 2;
                        targetPoint.isChecked = true;
                        virusPoints.add(targetPoint);
                    }
                }
            }
        }

    }

    private static boolean isMove(int updown, int rightLeft1, Point[][] points) {
        return updown >= 0 && updown < points.length && rightLeft1 >= 0 && rightLeft1 < points[0].length;
    }

    private static void constructWall(Point[][] points, Point emptySpace1, Point emptySpace2, Point emptySpace3) {
        points[emptySpace1.fromNorth][emptySpace1.fronWest].value = 1;
        points[emptySpace2.fromNorth][emptySpace2.fronWest].value = 1;
        points[emptySpace3.fromNorth][emptySpace3.fronWest].value = 1;
    }

    private static void initEmptySpaceAndVirusSpace(Point[][] emptySpaceAndVirusSpace, Point[][] points, Point[][] initPoints) {
        int emptyIndex = 0;
        int virusIndex = 0;
        for (Point[] point : points) {
            for (Point p : point) {
                if (p.value == 0) {
                    emptySpaceAndVirusSpace[0][emptyIndex++] = new Point(p.fromNorth, p.fronWest, p.value);
                }
                if (p.value == 2) {
                    emptySpaceAndVirusSpace[1][virusIndex++] = new Point(p.fromNorth, p.fronWest, p.value);
                }
            }
        }
    }

    private static void countEmptySpaceAndVirus(int[] emptySpaceAndVirusCount, Point[][] points) {
        int emptySpaceCount = 0;
        int virusCount = 0;
        for (Point[] point : points) {
            for (Point p : point) {
                if (p.value == 0) {
                    emptySpaceCount++;
                }
                if (p.value == 2) {
                    virusCount++;
                }
            }
        }
        emptySpaceAndVirusCount[0] = emptySpaceCount;
        emptySpaceAndVirusCount[1] = virusCount;
    }

    private static void initPoints(Point[][] points, Scanner sc) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                int value = sc.nextInt();
                points[i][j] = new Point(i, j, value);
            }
        }
    }

    static class Point {
        int value;
        int fromNorth;
        int fronWest;
        boolean isChecked;

        Point(int fromNorth, int fronWest, int value) {
            this.fromNorth = fromNorth;
            this.fronWest = fronWest;
            this.value = value;
        }

        @Override
        public String toString() {
            return isChecked +"";
        }
    }
}
