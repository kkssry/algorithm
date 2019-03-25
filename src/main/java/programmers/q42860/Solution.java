package programmers.q42860;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String name) {
        int answer = 0;
        int nowIndex = 0;

        char[] words = name.toCharArray();
        List<Word> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            list.add(new Word(words[i], i, words.length - i));
        }

        System.out.println(list);


        while (list.stream().filter(i -> i.isA).count() != list.size()) {
           loop: for (int i = nowIndex; i < list.size()-1; i++) {
                if (!list.get(nowIndex).isA) {
                    nowIndex = list.get(nowIndex).fromFirst;
                    answer += nowIndex;
                    answer += alphatCount(list.get(nowIndex).name);
                    System.out.println("카운트 : " + alphatCount(list.get(nowIndex).name));
                    list.get(nowIndex).isA = true;
                    System.out.println(list.get(nowIndex));
                    break loop;
                }
            }

            loop2 :for (int j = list.size() - 1; j >=0; j--) {
                if (!list.get(j).isA) {
                    answer += nowIndex - list.get(j).fromFirst;
                    answer += alphatCount(list.get(j).name);
                    list.get(j).isA = true;
                    nowIndex = list.get(j).fromFirst;
                    System.out.println(answer);
                    break loop2;
                }
            }

        }

        return answer;
    }

    private int alphatCount(char word) {
        if (word <= 'N') {
            return word  - 'A';
        }
        return ('Z' - word) + 1;
    }

    class Word {
        boolean isA = true;
        char name;
        int fromFirst;
        int fromBack;

        public Word(char name, int fromFirst, int fromBack) {
            if (name != 'A') {
                isA = false;
            }
            this.name = name;
            this.fromFirst = fromFirst;
            this.fromBack = fromBack;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "isA=" + isA +
                    ", name=" + name +
                    ", fromFirst=" + fromFirst +
                    ", fromBack=" + fromBack +
                    '}';
        }
    }

}
