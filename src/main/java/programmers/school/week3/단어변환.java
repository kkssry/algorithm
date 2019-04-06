package programmers.school.week3;

import java.util.Arrays;

public class 단어변환 {
    int result;

    public int solution(String begin, String target, String[] words) {
        int answer;
        boolean[] bol = new boolean[words.length];

        if (Arrays.stream(words).filter(i -> i.equals(target)).count() == 0) {
            return 0;
        }

        recursive(begin, target, words, bol);

        answer = result;
        return answer;
    }

    private void recursive(String begin, String target, String[] words, boolean[] bol) {
        char[] cha = begin.toCharArray();
        int targetCount = 0;

        for (int i = 0; i < cha.length; i++) {
            if (cha[i] == target.charAt(i)) {
               targetCount++;
            }
        }

        if (targetCount == begin.length() -1) {
            result++;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (bol[i]) {
                continue;
            }
            char[] wordsEle = words[i].toCharArray();
            int count = 0;
            for (int j = 0; j < wordsEle.length; j++) {
                if (cha[j] == wordsEle[j]) {
                    count++;
                }
            }

            if (count == begin.length() - 1) {
                result++;
                bol[i] = true;
                recursive(words[i], target, words, bol);
                return;
            }
        }

    }


}
