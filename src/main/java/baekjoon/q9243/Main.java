package baekjoon.q9243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String s1 = br.readLine();
        String s2 = br.readLine();
        if (count % 2 == 1) {
            if (isSame(s1, s2)) {
                System.out.println("Deletion failed");
            } else {
                System.out.println("Deletion succeeded");
            }
        } else {
            if (s1.equals(s2)) {
                System.out.println("Deletion succeeded");
            } else {
                System.out.println("Deletion failed");
            }
        }
    }

    private static boolean isSame(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                return true;
            }
        }
        return false;
    }


}
