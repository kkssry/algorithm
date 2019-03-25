package programmers.school.week2;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        List<Integer> completes = new ArrayList<>();
        Queue<Work> container = new LinkedList<>();
        int count;

        for (int i = 0; i < progresses.length; i++) {
            container.add(new Work(progresses[i] + speeds[i], speeds[i]));
        }

        while (!container.isEmpty()) {
            count = 0;
            for (int i = 0; i < container.size(); i++) {
                ((LinkedList<Work>) container)
                        .set(i, new Work(((LinkedList<Work>) container).get(i).progress + ((LinkedList<Work>) container)
                                .get(i).speed, ((LinkedList<Work>) container).get(i).speed));
            }

            while (!container.isEmpty()) {
                if (container.peek().progress >= 100) {
                    container.poll();
                    ++count;
                } else {
                    break;
                }
            }

            completes.add(count);

        }

        completes.removeAll(Arrays.asList(0));
        answer = completes.stream().mapToInt(i->i).toArray();
        return answer;
    }

    class Work {
        int progress;
        int speed;

        public Work(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        @Override
        public String toString() {
            return "progress{" +
                    "progress=" + progress +
                    ", speed=" + speed +
                    '}';
        }
    }
}
