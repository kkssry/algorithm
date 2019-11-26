package baekjoon.q4435;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resultCount = sc.nextInt();
        String[] results = new String[resultCount];
        for (int i = 0; i < resultCount; i++) {
            results[i] = saveResult(sc);
        }
        printResult(results);
    }

    private static void printResult(String[] results) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < results.length; i++) {
            int index = i + 1;
            sb.append("Battle ").append(index).append(": ").append(results[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String saveResult(Scanner sc) {
        GandalfUnit gandalfUnit = new GandalfUnit().initGandalfUnit(sc);
        SauronUnit sauronUnit = new SauronUnit().initSauronUnit(sc);
        int gandalfCombatPower = gandalfUnit.saveCombatPower();
        int sauronCombatPower = sauronUnit.saveCombatPower();
        if (gandalfCombatPower > sauronCombatPower) {
            return "Good triumphs over Evil";
        }
        if (gandalfCombatPower < sauronCombatPower) {
            return "Evil eradicates all trace of Good";
        }
        return "No victor on this battle field";
    }

    static class GandalfUnit {
        int hobbit;
        int human;
        int elf;
        int dwarf;
        int eagle;
        int wizard;

        GandalfUnit() {
        }

        GandalfUnit initGandalfUnit(Scanner sc) {
            this.hobbit = sc.nextInt();
            this.human = sc.nextInt() * 2;
            this.elf = sc.nextInt() * 3;
            this.dwarf = sc.nextInt() * 3;
            this.eagle = sc.nextInt() * 4;
            this.wizard = sc.nextInt() * 10;
            return this;
        }

        int saveCombatPower() {
            return hobbit + human + elf + dwarf + eagle + wizard;
        }
    }

    static class SauronUnit {
        int ork;
        int human;
        int wolf;
        int goblin;
        int urukhai;
        int troll;
        int wizard;

        SauronUnit initSauronUnit(Scanner sc) {
            this.ork = sc.nextInt();
            this.human = sc.nextInt() * 2;
            this.wolf = sc.nextInt() * 2;
            this.goblin = sc.nextInt() * 2;
            this.urukhai = sc.nextInt() * 3;
            this.troll = sc.nextInt() * 5;
            this.wizard = sc.nextInt() * 10;
            return this;
        }

        int saveCombatPower() {
            return ork + human + wolf + goblin + urukhai + troll + wizard;
        }
    }
}
