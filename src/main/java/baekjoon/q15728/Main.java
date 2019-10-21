package baekjoon.q15728;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cardCount = sc.nextInt();
        int checkCount = sc.nextInt();

        int[] sharingCards = new int[cardCount];
        int[] teamCards = new int[cardCount];
        boolean[] bol = new boolean[cardCount];
        initCards(sharingCards, teamCards, sc);

        int max = 0;
        int teamIndex = 0;

        for (int i = 0; i <= checkCount; i++) {
            max = Integer.MIN_VALUE;
            for (int sharingCard : sharingCards) {
                for (int k = 0; k < teamCards.length; k++) {
                    if (!bol[k] && max < sharingCard * teamCards[k]) {
                        max = sharingCard * teamCards[k];
                        teamIndex = k;
                    }
                }
            }
            bol[teamIndex] = true;
        }

        System.out.println(max);
    }

    private static void initCards(int[] sharingCards, int[] teamCards, Scanner sc) {
        for (int i = 0; i < sharingCards.length; i++) {
            sharingCards[i] = sc.nextInt();
        }

        for (int i = 0; i < teamCards.length; i++) {
            teamCards[i] = sc.nextInt();
        }
    }

}
