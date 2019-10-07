package programmers.q42884;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 1;

        Route[] routes1 = new Route[routes.length];
        initRoutes1(routes1, routes);
        Arrays.sort(routes1);
        int range = routes1[0].end;
        for (int i = 1; i < routes1.length; i++) {
            Route compareRoute = routes1[i];
            if (range < compareRoute.start) {
                answer++;
                range = compareRoute.end;
            } else {
                range = Math.min(range, compareRoute.end);
            }
        }

        return answer;
    }

    private void initRoutes1(Route[] routes1, int[][] routes) {
        for (int i = 0; i < routes.length; i++) {
            int start = Math.min(routes[i][0], routes[i][1]);
            int end = Math.max(routes[i][0], routes[i][1]); 
            routes1[i] = new Route(start, end);
        }
    }

    static class Route implements Comparable<Route> {
        int start;
        int end;

        Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Route o) {
            if (start == o.start) {
                return Integer.compare(end, o.end);
            }
            return Integer.compare(start, o.start);
        }

        @Override
        public String toString() {
            return "Route{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
