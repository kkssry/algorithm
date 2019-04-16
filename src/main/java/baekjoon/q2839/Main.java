package baekjoon.q2839;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int weight = Integer.parseInt(br.readLine());

        int fiveRest = weight % 5;
        int fiveMock = weight / 5;
        if (fiveRest == 0) {
            System.out.println(fiveMock);                             //5kg
            return;
        }

        for (int i = fiveMock; i >0; i--) {
            int five = i * 5;
            int mockFromDivideThree = (weight - five) % 3;

            if (mockFromDivideThree == 0) {
                mockFromDivideThree = (weight - five) / 3;
                System.out.println(i + mockFromDivideThree);       // 5kg + 3kg
                return;
            }
        }

        int mockFromDivideOnlyThreeWeight = weight % 3;
        if (mockFromDivideOnlyThreeWeight == 0) {
            mockFromDivideOnlyThreeWeight = weight / 3;
            System.out.println(mockFromDivideOnlyThreeWeight);                  // 3kg
            return;
        }

        System.out.println(-1);
    }
}



