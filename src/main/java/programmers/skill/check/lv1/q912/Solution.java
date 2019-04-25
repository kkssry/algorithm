package programmers.skill.check.lv1.q912;

public class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();

        String[] arr = s.split("");
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) {
                count = 0;
            } else {
                if (count % 2 == 0) {
                    arr[i] = arr[i].toUpperCase();
                } else {
                    arr[i] = arr[i].toLowerCase();
                }
                count++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}