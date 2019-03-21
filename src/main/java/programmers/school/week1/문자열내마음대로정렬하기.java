package programmers.school.week1;

import java.util.*;
import java.util.Collections;
import java.util.List;

public class 문자열내마음대로정렬하기 {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        List<Word> words = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            words.add(new Word(strings[i],strings[i].charAt(n)));
        }
        Collections.sort(words);

        answer = new String[words.size()];
        for (int i = 0; i < words.size(); i++) {
            answer[i] = words.get(i).name;
        }
        return answer;
    }

    class Word implements Comparable<Word>{
        String name;
        char word;

        public Word(String name, char word) {
            this.name = name;
            this.word = word;
        }

        @Override
        public int compareTo(Word o) {
            if(word > o.word) {
                return 1;
            }

            if (word < o.word) {
                return -1;
            }

            return name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return "Word{" +
                    "name='" + name + '\'' +
                    ", word=" + word +
                    '}';
        }
    }
}
