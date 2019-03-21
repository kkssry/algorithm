package programmers.q42746;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String solution(int[] numbers) {
        int length = numbers.length;
        String answer = "";
        List<String> numList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            numList.add(Integer.toString(numbers[i]));
        }

        Collections.sort(numList, (num1, num2) -> (num2 + num1).compareTo(num1 + num2));
        /*Collections.sort(numList, new Comparator<String>(){
                @Override
                public int compare(String num1,String num2){
                    return (num2+num1).compareTo(num1+num2);
                }
            });
            이렇게 작성했으나 지원하지 않는다고 IDE가 람다식으로 바꿔줌*/
        if (numList.get(0).equals("0")) {
            return "0";
        }

        for (int i = 0; i < numList.size(); i++) {
            answer += numList.get(i);
        }

        return answer;
    }


}
