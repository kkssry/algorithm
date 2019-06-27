package baekjoon.q1966;


import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        int[] tests = new int[testCount];
        runEachTest(tests, scan);
        IntStream.of(tests).forEach(System.out::println);
    }

    private static void runEachTest(int[] tests, Scanner scan) {
        for (int i = 0; i < tests.length; i++) {
            int paperCount = scan.nextInt();
            int findPaperIndex = scan.nextInt();
            List<Paper> papers = new LinkedList<>();
            initPapers(papers, paperCount, findPaperIndex, scan);
            tests[i] = saveFindPaper(papers);
        }
    }

    private static int saveFindPaper(List<Paper> papers) {
        int count = 0;

        while (!papers.isEmpty()) {
            Paper paper = papers.get(0);
            if (papers.stream().noneMatch(paper1 -> paper1.priority > paper.priority)) {
                count++;
                if (!paper.flag) {
                    papers.remove(paper);
                    continue;
                } else {
                    return count;
                }
            }
            papers.remove(paper);
            papers.add(paper);
        }

        return count;
    }

    private static void initPapers(List<Paper> papers, int paperCount, int findPaperIndex, Scanner scan) {
        for (int i = 0; i < paperCount; i++) {
            int priority = scan.nextInt();
            if (i == findPaperIndex) {
                papers.add(new Paper(priority, true));
                continue;
            }
            papers.add(new Paper(priority));
        }
    }

    static class Paper {
        int priority;
        boolean flag;

        Paper(int priority) {
            this.priority = priority;
        }

        Paper(int priority, boolean flag) {
            this.priority = priority;
            this.flag = flag;
        }

        @Override
        public String toString() {
            return "Paper{" +
                    "priority=" + priority +
                    ", flag=" + flag +
                    '}';
        }
    }
}
