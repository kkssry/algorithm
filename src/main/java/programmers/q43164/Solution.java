package programmers.q43164;

import java.util.*;

public class Solution {
    List<String[]> paths = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean isRight = true;

    public String[] solution(String[][] tickets) {
        String[] answer = {};

        boolean[] bol = new boolean[tickets.length];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                }
                if (o2[0].equals("ICN")) {
                    return 1;
                }
                if (o1[0].equals("ICN")) {
                    return -1;
                }

                return o1[1].compareTo(o2[1]);
            } 
        });

//        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));


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

        for (int i = 0; i < paths.size(); i++) {
            System.out.println(Arrays.toString(paths.get(i)));
        }
//        System.out.println(Arrays.deepToString(paths));

        answer = paths.get(0);


        return answer;
    }

    private void recursive(String[][] tickets, boolean[] bol, String start, int pathCount) {

        int trueCount = 0;
        for (int i = 0; i < bol.length; i++) {
            if (bol[i]) {
                trueCount++;
            }
        }

        if (trueCount == tickets.length) {
//            System.out.println(path);
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
                isRight = true;
                bol[i] = true;
                if (pathCount == 0) {
                    path.add(start);
                }
                start = tickets[i][1];
                path.add(start);
                recursive(tickets, bol, start, pathCount + 1);
                bol[i] = false;
                int count = 0;
                for (int j = 0; j < tickets.length; j++) {
                    if (tickets[j][0].equals(start) && !bol[j]) {
                        count++;
                    }
                }
                if (count > 1) {
//                    start = tickets[i][0];

                    return;
                }
//                return;
                if (!isRight) {
                    start = tickets[i][0];
                    continue loop;
                }
                if (pathCount == 0) {
                    start = "ICN";
                    continue loop;
                } else {
                    return;
                }
            }
        }
        if (pathCount != 0) {
            path.remove(path.size() - 1);
            isRight = false;
        }
    }
}

