package baekjoon.q2563;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int colorPaperCount = sc.nextInt();
        int[][] startPotions = new int[colorPaperCount][2];
        initStartPositions(startPotions, sc);
        Set<Point> points = new HashSet<>();
        savePointCount(startPotions, points);
        System.out.println(points.size());
    }

    private static void savePointCount(int[][] startPotions, Set<Point> points) {
        for (int[] startPotion : startPotions) {
            int x = startPotion[0];
            int y = startPotion[1];
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    points.add(new Point(j, k));
                }
            }
        }

    }

    private static void initStartPositions(int[][] startPotions, Scanner sc) {
        for (int i = 0; i < startPotions.length; i++) {
            for (int j = 0; j < startPotions[i].length; j++) {
                startPotions[i][j] = sc.nextInt();
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
