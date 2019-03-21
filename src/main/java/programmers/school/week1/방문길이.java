package programmers.school.week1;

import java.util.*;

public class 방문길이 {
    public int solution(String dirs) {
        int answer = 0;

        String[] directions = dirs.split("");
        List<Line> coordinates = new ArrayList<>();
        Set<Line> walkingCount = new HashSet<>();
        Point nowPoint = new Point(0,0);



        for (int i = 0; i < directions.length; i++) {
            if (i == 0) {
                if (directions[i].equals("U")) {
                    Point newPoint = new Point(nowPoint.x,nowPoint.y + 1);
                    coordinates.add(new Line(nowPoint, newPoint ));
                    nowPoint = newPoint;
                }
                if (directions[i].equals("D")) {
                    coordinates.add(new Line(nowPoint, new Point(0, -1)));
                }
                if (directions[i].equals("R")) {
                    coordinates.add(new Line(nowPoint, new Point(1, 0)));
                }
                if (directions[i].equals("L")) {
                    coordinates.add(new Line(nowPoint, new Point(-1, 0)));
                }
                continue;
            }

            if (directions[i].equals("U")) {
                coordinates.add(new Line(new Point(coordinates.get(i - 1).p2.x,coordinates.get(i - 1).p2.y),  new Point(coordinates.get(i - 1).p2.x, coordinates.get(i -1).p2.y + 1)));
            }
            if (directions[i].equals("D")) {
                coordinates.add(new Line(new Point(coordinates.get(i - 1).p2.x,coordinates.get(i - 1).p2.y),  new Point(coordinates.get(i - 1).p2.x, coordinates.get(i -1).p2.y - 1)));
            }
            if (directions[i].equals("R")) {
                coordinates.add(new Line(new Point(coordinates.get(i - 1).p2.x,coordinates.get(i - 1).p2.y),  new Point(coordinates.get(i - 1).p2.x + 1, coordinates.get(i -1).p2.y)));
            }
            if (directions[i].equals("L")) {
                coordinates.add(new Line(new Point(coordinates.get(i - 1).p2.x,coordinates.get(i - 1).p2.y),  new Point(coordinates.get(i - 1).p2.x - 1, coordinates.get(i -1).p2.y)));
            }

        }


        for (int i = 0; i < coordinates.size(); i++) {
            if (!coordinates.get(i).isEqualPoint()) {
                walkingCount.add(coordinates.get(i).sortPoint());
            }
        }

        answer = walkingCount.size();
        return answer;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            if (Math.abs(this.x) > 5) {
                if (this.x < 0) {
                    this.x = -5;
                }
                if (this.x > 0) {
                    this.x = 5;
                }
            }
            this.y = y;
            if (Math.abs(this.y) > 5) {
                if (this.y < 0) {
                    this.y = -5;
                }
                if (this.y > 0) {
                    this.y = 5;
                }
            }

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point that = (Point) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }


        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    class Line {
        Point p1;
        Point p2;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Line)) return false;
            Line line = (Line) o;
            return p1.equals(line.p1) &&
                    p2.equals(line.p2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(p1, p2);
        }

        @Override
        public String toString() {
            return "Line{" +
                    "p1=" + p1 +
                    ", p2=" + p2 +
                    '}';
        }

        public Line sortPoint() {
            Point tmp;
            if (p1.x > p2.x) {
                tmp = p2;
                p2 = p1;
                p1 = tmp;
            }
            if (p1.y > p2.y) {
                tmp = p2;
                p2 = p1;
                p1 = tmp;
            }

            return this;
        }

        public boolean isEqualPoint() {
            return p1.equals(p2);
        }
    }
}
