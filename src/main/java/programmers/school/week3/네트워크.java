package programmers.school.week3;

import java.util.Stack;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        // 1번째 풀이법
        boolean[] visitManage = new boolean[n];
        for (int i = 0; i < visitManage.length; i++) {
            if (!visitManage[i]) {
                answer++;
                visitAll(visitManage, i, computers);
            }
        }

        //2번째 풀이법법
//      Search s = new Search(n,computers);
//        for (int i = 0; i < n; i++) {
//            if (!s.isvisit(i)) {
//                ++answer;
//                s.bfs(i);
//            }
//        }

        return answer;
    }

    private void visitAll(boolean[] visitManage, int i, int[][] computers) {
        if (visitManage[i]) return;

        visitManage[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1) {
                visitAll(visitManage,i,computers);
            }
        }

    }


//    private class Search {
//        boolean[] visitManage;
//        int[][] computers;
//
//        public Search(int n, int[][] computers) {
//            this.visitManage = new boolean[n];
//            this.computers = computers;
//        }
//
//        public boolean isvisit(int i) {
//            return visitManage[i];
//        }
//
//        public void bfs(int i) {
//            Stack<Integer> stack = new Stack<>();
//            stack.push(i);
//            while(!stack.isEmpty()) {
//                int computer = stack.pop();
//                visitManage[computer] = true;
//                for (int j = 0; j < computers[computer].length; j++) {
//                    if (computers[computer][j] == 1 && !visitManage[j]) {
//                        stack.push(j);
//                    }
//                }
//            }
//
//        }
//    }

}
