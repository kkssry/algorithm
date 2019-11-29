package baekjoon.q2869;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dayDistance = sc.nextInt();
        int nightDistance = sc.nextInt();
        int targetDistance = sc.nextInt();

        int count = 0;
        targetDistance -= dayDistance;
        count++;
        if (targetDistance <= 0) {
            System.out.println(count);
            return;
        }

        int oneDayDistance = dayDistance - nightDistance;
        count += targetDistance / oneDayDistance;
        if (targetDistance % oneDayDistance > 0) {
            count++;
        }
        System.out.println(count);
    }
}
