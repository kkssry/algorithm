package baekjoon.q11507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String problem = br.readLine();
        int chunkCount = problem.length() / 3;
        List<String> lostCards = new ArrayList<>();
        initLostCards(problem, lostCards, chunkCount);

        Set<String> duplicateChecker = new HashSet<>(lostCards);
        if (lostCards.size() != duplicateChecker.size()) {
            System.out.println("GRESKA");
            return;
        }

        Map<String, Integer> cards = new HashMap<>();
        initCards(cards);
        removeLostCardsFromCards(cards, lostCards);
        printResult(cards);

    }

    private static void initLostCards(String problem, List<String> lostCards, int chunkCount) {
        for (int i = 0; i < chunkCount; i++) {
            lostCards.add(problem.substring(3 * i, 3 * (i + 1)));
        }
    }

    private static void printResult(Map<String, Integer> cards) {
        int[] cardCount = new int[4];
        cardCount[0] = cards.get("P");
        cardCount[1] = cards.get("K");
        cardCount[2] = cards.get("H");
        cardCount[3] = cards.get("T");

        String result = IntStream.of(cardCount).mapToObj(i -> i + "").collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static void removeLostCardsFromCards(Map<String, Integer> cards, List<String> lostCards) {
        for (String lostCard : lostCards) {
            String cardPattern = lostCard.charAt(0) + "";
            cards.put(cardPattern, cards.get(cardPattern) - 1);
        }
    }

    private static void initCards(Map<String, Integer> cards) {
        cards.put("P", 13);
        cards.put("K", 13);
        cards.put("H", 13);
        cards.put("T", 13);
    }
}
