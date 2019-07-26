package baekjoon.q1012;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        int[] results = new int[testCount];
        executeTest(testCount, sc, results);
        IntStream.of(results).forEach(System.out::println);
    }

    private static void executeTest(int testCount, Scanner sc, int[] results) {
        for (int i = 0; i < testCount; i++) {
            int yardFromWest = sc.nextInt();
            int yardFromNorth = sc.nextInt();
            int cabbageCount = sc.nextInt();
            Cabagge[][] cabbageYard = new Cabagge[yardFromNorth][yardFromWest];
            initCabbageYard(cabbageYard);
            initCabbage(cabbageYard, cabbageCount, sc);
            bindCabbageArea(cabbageYard);
            results[i] = countCabbageIdentity(cabbageYard);
        }
    }

    private static void initCabbageYard(Cabagge[][] cabbageYard) {
        for (int i = 0; i < cabbageYard.length; i++) {
            for (int j = 0; j < cabbageYard[i].length; j++) {
                cabbageYard[i][j] = new Cabagge(i, j);
            }
        }
    }

    private static void initCabbage(Cabagge[][] cabbageYard, int cabbageCount, Scanner sc) {
        for (int i = 0; i < cabbageCount; i++) {
            int cabbageFromWest = sc.nextInt();
            int cabbageFromNorth = sc.nextInt();
            cabbageYard[cabbageFromNorth][cabbageFromWest].isCabbage = true;
        }
    }

    private static void bindCabbageArea(Cabagge[][] cabbageYard) {
        char identifier = 'a';
        for (Cabagge[] cabagges : cabbageYard) {
            for (Cabagge cabagge : cabagges) {
                if (cabagge.isCabbage && !cabagge.isCheck) {
                    cabagge.identity = identifier;
                    cabagge.isCheck = true;
                    startBind(cabagge, cabbageYard, identifier);
                    identifier++;
                }
            }
        }
    }

    private static int countCabbageIdentity(Cabagge[][] cabbageYard) {
        Set<Character> identities = new HashSet<>();
        for (Cabagge[] cabagges : cabbageYard) {
            for (Cabagge cabagge : cabagges) {
                if (cabagge.identity > 0) {
                    identities.add(cabagge.identity);
                }
            }
        }
        return identities.size();
    }

    private static void startBind(Cabagge cabagge, Cabagge[][] cabbageYard, char identifier) {
        int fromNorth = cabagge.fromNorth;
        int fromWest = cabagge.fromWest;

        if (fromNorth > 0) {
            Cabagge northCabbage = cabbageYard[fromNorth - 1][fromWest];
            proceedBind(northCabbage, cabbageYard, identifier);
        }

        if (fromWest < cabbageYard[0].length - 1) {
            Cabagge eastCabbage = cabbageYard[fromNorth][fromWest + 1];
            proceedBind(eastCabbage, cabbageYard, identifier);
        }

        if (fromNorth < cabbageYard.length - 1) {
            Cabagge southCabbage = cabbageYard[fromNorth + 1][fromWest];
            proceedBind(southCabbage, cabbageYard, identifier);
        }

        if (fromWest > 0) {
            Cabagge westCabbage = cabbageYard[fromNorth][fromWest - 1];
            proceedBind(westCabbage, cabbageYard, identifier);
        }

    }

    private static void proceedBind(Cabagge currentCabbage, Cabagge[][] cabbageYard, char identifier) {
        if (currentCabbage.isCabbage && !currentCabbage.isCheck) {
            currentCabbage.isCheck = true;
            currentCabbage.identity = identifier;
            startBind(currentCabbage, cabbageYard, identifier);
        }
    }

    static class Cabagge {
        int fromNorth;
        int fromWest;
        boolean isCabbage;
        char identity;
        boolean isCheck;

        Cabagge(int fromNorth, int fromWest) {
            this.fromNorth = fromNorth;
            this.fromWest = fromWest;
        }

        @Override
        public String toString() {
            return "Cabagge{" +
                    "fromNorth=" + fromNorth +
                    ", fromWest=" + fromWest +
                    ", identity=" + identity +
                    '}';
        }
    }
}
