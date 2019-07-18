package baekjoon.q16932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int maxConnetedCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] heightAndWidth = new int[2];
        initHeightAndWidth(heightAndWidth, br);
        Point[][] points = new Point[heightAndWidth[0]][heightAndWidth[1]];
        initPoints(points, br);
        groupify(points);
        saveResult(points);
        if (maxConnetedCount == 0) {
            System.out.println(heightAndWidth[0] * heightAndWidth[1]);
            return;
        }

        System.out.println(maxConnetedCount);
    }

    private static void saveResult(Point[][] points) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (points[i][j].value == 0) {
                    saveMaxCount(points, i, j);
                }
            }
        }
    }

    private static void saveMaxCount(Point[][] points, int fromNorth, int fromWest) {
        Set<Point> neighboringCount = new HashSet<>();
        if (fromNorth - 1 >= 0) {
            neighboringCount.add(points[fromNorth - 1][fromWest]);
        }
        if (fromNorth + 1 < points.length) {
            neighboringCount.add(points[fromNorth + 1][fromWest]);
        }
        if (fromWest - 1 >= 0) {
            neighboringCount.add(points[fromNorth][fromWest - 1]);
        }
        if (fromWest + 1 < points[0].length) {
            neighboringCount.add(points[fromNorth][fromWest + 1]);
        }
        sum(neighboringCount);
    }

    private static void sum(Set<Point> neighboringCount) {
        int sum = 1;
        for (Point point : neighboringCount) {
            sum += point.value;
        }
        if (maxConnetedCount < sum) {
            maxConnetedCount = sum;
        }
    }

    private static void groupify(Point[][] points) {
        char a = 'a';
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (points[i][j].value == 1) {
                    int count = startConnect(points, i, j);
                    a += 1;
                    String identify = String.valueOf(a);
                    groupifyDetail(points, count, i, j, identify);
                }
            }
        }
    }

    private static void groupifyDetail(Point[][] points, int count, int fromNorth1, int fromWest2, String identify) {
        Point targetPoint = points[fromNorth1][fromWest2];
        targetPoint.identity = identify;
        Queue<Point> queue = new LinkedList<>();
        queue.add(targetPoint);
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int fromNorth = point.fromNorth;
            int fromWest = point.fromWest;

            if (fromNorth - 1 >= 0 && points[fromNorth - 1][fromWest].isChecked && points[fromNorth - 1][fromWest].value == 1) {
                points[fromNorth - 1][fromWest].value = count;
                points[fromNorth - 1][fromWest].identity = identify;
                queue.add(points[fromNorth - 1][fromWest]);
            }

            if (fromNorth + 1 < points.length && points[fromNorth + 1][fromWest].isChecked && points[fromNorth + 1][fromWest].value == 1) {
                points[fromNorth + 1][fromWest].value = count;
                points[fromNorth + 1][fromWest].identity = identify;
                queue.add(points[fromNorth + 1][fromWest]);
            }

            if (fromWest - 1 >= 0 && points[fromNorth][fromWest - 1].isChecked && points[fromNorth][fromWest - 1].value == 1) {
                points[fromNorth][fromWest - 1].value = count;
                points[fromNorth][fromWest - 1].identity = identify;
                queue.add(points[fromNorth][fromWest - 1]);
            }

            if (fromWest + 1 < points[0].length && points[fromNorth][fromWest + 1].isChecked && points[fromNorth][fromWest + 1].value == 1) {
                points[fromNorth][fromWest + 1].value = count;
                points[fromNorth][fromWest + 1].identity = identify;
                queue.add(points[fromNorth][fromWest + 1]);
            }
        }
    }


    private static int startConnect(Point[][] points, int fromNorth1, int fromWest2) {
        int count = 0;
        Point targetPoint = points[fromNorth1][fromWest2];
        points[fromNorth1][fromWest2].isChecked = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(targetPoint);

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            count++;
            int fromNorth = point.fromNorth;
            int fromWest = point.fromWest;

            if (fromNorth - 1 >= 0 && points[fromNorth - 1][fromWest].value == 1 && !points[fromNorth - 1][fromWest].isChecked) {
                points[fromNorth - 1][fromWest].isChecked = true;
                queue.add(points[fromNorth - 1][fromWest]);
            }

            if (fromNorth + 1 < points.length && points[fromNorth + 1][fromWest].value == 1 && !points[fromNorth + 1][fromWest].isChecked) {
                points[fromNorth + 1][fromWest].isChecked = true;
                queue.add(points[fromNorth + 1][fromWest]);
            }

            if (fromWest - 1 >= 0 && points[fromNorth][fromWest - 1].value == 1 && !points[fromNorth][fromWest - 1].isChecked) {
                points[fromNorth][fromWest - 1].isChecked = true;
                queue.add(points[fromNorth][fromWest - 1]);
            }

            if (fromWest + 1 < points[0].length && points[fromNorth][fromWest + 1].value == 1 && !points[fromNorth][fromWest + 1].isChecked) {
                points[fromNorth][fromWest + 1].isChecked = true;
                queue.add(points[fromNorth][fromWest + 1]);
            }
        }
        return count;
    }

    private static void initPoints(Point[][] points, BufferedReader br) throws IOException {
        for (int i = 0; i < points.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = new Point(i, j, Integer.parseInt(st.nextToken()));
            }
        }
    }

    private static void initHeightAndWidth(int[] heightAndWidth, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < heightAndWidth.length; i++) {
            heightAndWidth[i] = Integer.parseInt(st.nextToken());
        }
    }

    static class Point {
        int fromNorth;
        int fromWest;
        int value;
        boolean isChecked;
        String identity;

        public Point(int fromNorth, int fromWest, int value) {
            this.fromNorth = fromNorth;
            this.fromWest = fromWest;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return Objects.equals(identity, point.identity);
        }

        @Override
        public int hashCode() {
            return Objects.hash(identity);
        }

        @Override
        public String toString() {
            return value +"";
        }
    }
}
