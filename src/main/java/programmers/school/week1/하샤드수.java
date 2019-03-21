package programmers.school.week1;

public class 하샤드수 {
    public boolean solution(int x) {
        boolean answer;

        String number = x + "";
        int hashad = 0;

        String[] numbers = number.split("");
        for (int i = 0; i < number.length(); i++) {
            hashad += Integer.parseInt(numbers[i]);
        }

        for (int i = 0; i < number.length(); i++) {
            hashad += Character.getNumericValue(number.charAt(i));
        }

        answer = (x % hashad) == 0;

        return answer;
    }
}
