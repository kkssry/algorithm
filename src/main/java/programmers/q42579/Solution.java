package programmers.q42579;

import java.util.*;

public class Solution {
    public int[] solution(String[] geres, int[] plays) {
        int[] answer = {};
        int flag = 0;
        List<Genres> list = new ArrayList<>();

        for (int i = 0; i < geres.length; i++) {
            list.add(new Genres(geres[i], plays[i], i));
        }

        Collections.sort(list);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < geres.length; i++) {
            set.add(geres[i]);
        }

        Map<String, Integer> map = new HashMap<>();
        int sum = 0;

        for (String genres : set) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).gere.equals(genres)) {
                    sum += list.get(i).playCount;
                }
            }
            map.put(genres, sum);
            sum = 0;
        }


        List<Integer> playCount = new ArrayList<>();
        for (String s : set) {
            playCount.add(map.get(s));
        }

        Collections.sort(playCount, (o1, o2) -> o2 - o1);

        List<String> genreRank = new ArrayList<>();

        for (int i = 0; i < playCount.size(); i++) {
            for (String s : map.keySet()) {
                if (playCount.get(i) == map.get(s)) {
                    genreRank.add(s);
                }
            }
        }

        System.out.println(genreRank);

        List<Genres> bestAlbum = new ArrayList<>();

        for (int i = 0; i < genreRank.size(); i++) {
            flag = 0;
            loop:
            for (int j = 0; j < list.size(); j++) {
                if (genreRank.get(i).equals(list.get(j).gere)) {
                    flag++;
                    if (flag > 2) {
                        break loop;
                    }
                    bestAlbum.add(list.get(j));
                }
            }

        }

        System.out.println(bestAlbum);
        answer = new int[bestAlbum.size()];

        for (int i = 0; i < bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i).index;
        }

        return answer;
    }

    class Genres implements Comparable<Genres> {
        String gere;
        int playCount;
        int index;

        public Genres(String gere, int play, int index) {
            this.gere = gere;
            this.playCount = play;
            this.index = index;
        }

        @Override
        public int compareTo(Genres o) {
            if (playCount > o.playCount) {
                return -1;
            } else if (playCount < o.playCount) {
                return 1;
            }

            if (index - o.index > 0) {
                return 1;
            } else if (index - o.index < 0) {
                return -1;
            }

            return 0;
        }

        @Override
        public String toString() {
            return "Genres{" +
                    "gere='" + gere + '\'' +
                    ", playCount=" + playCount +
                    ", index=" + index +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Genres genres = (Genres) o;
            return playCount == genres.playCount &&
                    Objects.equals(gere, genres.gere);
        }

        @Override
        public int hashCode() {
            return Objects.hash(gere, playCount);
        }
    }
}

