package baekjoon.q17294;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String number = scan.next();
        if (number.length() == 1) {
            System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
            return;
        }

        int num = number.charAt(0) - number.charAt(1);
        for (int i = 1; i < number.length() - 1; i++) {
           if (number.charAt(i) - number.charAt(i + 1) != num) {
               System.out.println("흥칫뿡!! <(￣ ﹌ ￣)>");
               return;
           }
        }

        System.out.println("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!");
    }
}
