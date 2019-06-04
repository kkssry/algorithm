package baekjoon.q2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int[] rowAndColumn = inputRowColumn();
        int[][] maze = new int[rowAndColumn[0]][rowAndColumn[1]];
        initMaze(maze);
        int optimizeCount = bestEscapeCount(maze);
        printResult(optimizeCount);
    }

    private static int bestEscapeCount(int[][] maze) {
        int optimizeEscapeCount = 0;
        Queue<Point> points = new LinkedList<>();
        points.add(new Point(0,0,0));

        while (!points.isEmpty()) {
            Point point = points.poll();

            if (point.row > 0 && maze[point.row - 1][point.column] == 1) {
                maze[point.row - 1][point.column] = 0;
                points.add(new Point(point.row - 1, point.column, point.count + 1));
            }

            if (point.column < maze[0].length - 1 && maze[point.row][point.column + 1] == 1) {
                maze[point.row][point.column + 1] = 0;
                points.add(new Point(point.row, point.column + 1, point.count + 1));
            }

            if (point.row < maze.length - 1 && maze[point.row + 1][point.column] == 1) {
                maze[point.row + 1][point.column] = 0;
                points.add(new Point(point.row + 1, point.column, point.count + 1));
            }

            if (point.column > 0 && maze[point.row][point.column - 1] == 1) {
                maze[point.row][point.column - 1] = 0;
                points.add(new Point(point.row, point.column - 1, point.count + 1));
            }

            if (point.row == maze.length - 1 && point.column == maze[0].length - 1) {
                optimizeEscapeCount = point.count + 1;
            }
        }

        return optimizeEscapeCount;
    }

    private static void initMaze(int[][] maze) throws IOException {
        for (int i = 0; i < maze.length; i++) {
            maze[i] = Arrays.stream(scan.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
    }

    private static int[] inputRowColumn() throws IOException {
        int[] rowAndColumn;
        rowAndColumn = Arrays.stream(scan.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        return rowAndColumn;
    }

    private static void printResult(int optimizeCount) {
        System.out.println(optimizeCount);
    }

    static class Point{
        int row;
        int column;
        int count;

        public Point(int row, int column, int count) {
            this.row = row;
            this.column = column;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "row=" + row +
                    ", column=" + column +
                    ", count=" + count +
                    '}';
        }
    }
}
