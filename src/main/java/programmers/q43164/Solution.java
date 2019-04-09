package programmers.q43164;

import java.util.*;

public class Solution {
    List<String[]> paths = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        boolean[] bol = new boolean[tickets.length];

        recursive(tickets, bol, "ICN", 0);


        Collections.sort(paths, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                for (int i = 0; i < o1.length; i++) {
                    for (int j = 0; j < o1[i].length(); j++) {
                        if (o1[i].charAt(j) > o2[i].charAt(j)) {
                            return 1;
                        }
                        if (o1[i].charAt(j) < o2[i].charAt(j)) {
                            return -1;
                        }
                    }
                }
                return 0;
            }
        });

        answer = paths.get(0);


        return answer;
    }

    private void recursive(String[][] tickets, boolean[] bol, String start, int pathCount) {
        int count = 0;
        for (int i = 0; i < bol.length; i++) {
            if (bol[i]) {
                count++;
            }
        }

        if (count == tickets.length) {
            String[] temp = new String[path.size()];
            paths.add(path.toArray(temp));
            path.clear();
            return;
        }

        loop:
        for (int i = 0; i < tickets.length; i++) {
            if (bol[i]) {
                continue;
            }

            if (tickets[i][0].equals(start) && !bol[i]) {
                bol[i] = true;
                if (pathCount == 0) {
                    path.add(start);
                }
                start = tickets[i][1];
                path.add(start);
                recursive(tickets, bol, start, pathCount + 1);
                bol[i] = false;
                if (pathCount == 0) {
                    start = "ICN";
                    continue loop;
                } else {
                    return;
                }
            }
        }

    }
}

