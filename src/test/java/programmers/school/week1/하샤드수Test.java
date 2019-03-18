package programmers.school.week1;

import org.junit.Test;

public class 하샤드수Test {
    @Test
    public void mainTest() {
        int[] arr = {10,12,11,13};
        하샤드수 하샤드 = new 하샤드수();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(하샤드.solution(arr[i]));
        }
    }

    @Test
    public void 스트링n번째문자열() {
        String a = "Asdf";
        System.out.println(a.charAt(0));
        System.out.println(a.charAt(1));
        System.out.println(a.charAt(2));
        System.out.println(a.charAt(3));
        System.out.println("---------------");
        System.out.println(a.length());
    }
}