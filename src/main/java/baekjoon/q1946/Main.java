package baekjoon.q1946;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        int[] tests = new int[testCount];
        runTests(tests, scan);
        IntStream.of(tests).forEach(System.out::println);
    }

    private static void runTests(int[] tests, Scanner br) {
        for (int i = 0; i < tests.length; i++) {
            int newbieCount = br.nextInt();
            Newbie[] newbies = new Newbie[newbieCount];
            initNewbie(newbies, br);
            Arrays.sort(newbies);
            judgeFailNewbie(newbies);
            tests[i] = printResult(newbies);
        }
    }

    private static int printResult(Newbie[] newbies) {
        return (int) Stream.of(newbies).filter(i->!i.isFail).count();
    }

    private static void judgeFailNewbie(Newbie[] newbies) {
        int interview = newbies[0].interview;
        for (int i = 1; i < newbies.length; i++) {
            interview = Math.min(interview, newbies[i].interview);
            if (interview < newbies[i].interview) {
                newbies[i].isFail = true;
            }
        }
    }

    private static void initNewbie(Newbie[] newbies, Scanner br) {
        for (int i = 0; i < newbies.length; i++) {
            int paper = br.nextInt();
            int interview = br.nextInt();
            newbies[i] = new Newbie(paper, interview);
        }
    }


    static class Newbie implements Comparable<Newbie> {
        int paper;
        int interview;
        boolean isFail;

        Newbie(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(Newbie o) {
            return Integer.compare(paper, o.paper);
        }
    }
}
