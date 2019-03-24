package programmers.school.week2;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            String startWord = phone_book[i];
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) {
                    continue;
                }

                if (phone_book[j].startsWith(startWord)) {
                    return false;
                }
            }
        }

        return answer;
    }
}
