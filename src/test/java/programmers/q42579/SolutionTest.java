package programmers.q42579;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        String[] arr = {"classic","pop","classic","pop","classic","classic"};
        int[] plays = {400,600,150,2500,500,500};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(arr,plays)));
    }

    @Test
    public void setTest() {
        Set<Player> players = new HashSet<>();
        List<Player> list = new ArrayList<>();

        Player p1 = new Player("skull",21);
        Player p2 = new Player("skull",22);
        Player p3 = new Player("lime",24);

        players.add(p1);
        players.add(p2);
        players.add(p3);

        list.add(p1);
        list.add(p2);
        list.add(p3);

        Collections.sort(list);

        for (Player player : players) {
            System.out.println(player.name);
        }
        System.out.println(players.size());

        System.out.println("-------------------");

        for (int l = 0; l < list.size(); l++) {
            System.out.println(list.get(l));
        }

    }

    class Player implements Comparable<Player>{
        String name;
        int age;

        public Player(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Player player = (Player) o;
            return Objects.equals(name, player.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public int compareTo(Player o) {
            if (age - o.age > 0) {
                return -1;
            } else if(age - o.age < 0) {
                return 1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "Player{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    @Test
    public void breakTest() {
        for (int i = 0; i < 10; i++) {
            if (i > 2) {
                break;
            }
            System.out.println(i);
        }
    }
}