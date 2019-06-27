package baekjoon.q1966;

import com.google.common.base.Objects;
import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class MainTest {
    class Paper implements Comparable<Paper>{
        int priority;
        boolean flag;

        public Paper(int priority) {
            this.priority = priority;
        }

        public Paper(int priority, boolean flag) {
            this.priority = priority;
            this.flag = flag;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Paper)) return false;
            Paper paper = (Paper) o;
            return priority == paper.priority;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(priority);
        }

        @Override
        public String toString() {
            return "Paper{" +
                    "priority=" + priority +
                    ", flag=" + flag +
                    '}';
        }

        @Override
        public int compareTo(Paper o) {
            return -Integer.compare(priority,o.priority);
        }
    }

    @Test
    public void 중요도test() {
        PriorityQueue<Paper> papers = new PriorityQueue<>();        //값이 같으면 랜덤으로 뽑는다.
        for (int i = 0; i < 4; i++) {
            if (i == 2) {
                papers.add(new Paper(i, true));
                continue;
            }
            papers.add(new Paper(i));
        }

        int count = 0;
        while(!papers.isEmpty()) {
            Paper paper = papers.poll();
            count++;
            if (paper.flag) {
                System.out.println("중요도 : " + paper.priority);
                System.out.println(count);
            }
        }
    }

    @Test
    public void 같은중요도test() {
        PriorityQueue<Paper> papers = new PriorityQueue<>();
        papers.add(new Paper(1, true));
        papers.add(new Paper(1));
        papers.add(new Paper(9));
        papers.add(new Paper(1));
        papers.add(new Paper(1));
        papers.add(new Paper(1));


        int count = 0;
        while(!papers.isEmpty()) {
            Paper paper = papers.poll();
            count++;
            if (paper.flag) {
                System.out.println("중요도 : " + paper.priority);
                System.out.println(count);
            }
        }
    }
}