package baekjoon.use.string.q2675;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        StringAndNumber[] san = new StringAndNumber[num];
        initSan(num, san, scan);
        printString(san);
    }

    private static void initSan(int num, StringAndNumber[] san, Scanner scan) {
        for (int i = 0; i < num; i++) {
            String[] repeatNumAndString = scan.nextLine().split(" ");
            int repeatNum = Integer.parseInt(repeatNumAndString[0]);
            san[i] = new StringAndNumber(repeatNum, repeatNumAndString[1]);
        }
    }

    private static void printString(StringAndNumber[] san) {
        for (int i = 0; i < san.length; i++) {
            for (int j = 0; j < san[i].str.length(); j++) {
                for (int k = 0; k < san[i].repeatNum; k++) {
                    System.out.print(san[i].str.charAt(j));
                }
            }
            System.out.println();
        }
    }

    static class StringAndNumber {
        int repeatNum;
        String str;

        public StringAndNumber(int repeatNum, String str) {
            this.repeatNum = repeatNum;
            this.str = str;
        }

        @Override
        public String toString() {
            return "StringAndNumber{" +
                    "repeatNum=" + repeatNum +
                    ", str='" + str + '\'' +
                    '}';
        }
    }

}
