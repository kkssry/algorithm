package programmers.skill.check.lv3.q2557;

import java.util.*;

public class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Node[] nodes = new Node[n + 1];
        initNodes(nodes);
        eachNodeMapping(nodes, edge);
        startDistantNodes(nodes);
        int max = Arrays.stream(nodes).mapToInt(node -> node.count).max().getAsInt();
        answer = (int) Arrays.stream(nodes).filter(node -> node.count == max).count();
        return answer;
    }

    private void startDistantNodes(Node[] nodes) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes[1]);
        nodes[1].isChecked = true;
        while (!queue.isEmpty()) {
            Node nodeOutputed = queue.poll();
            for (Node node : nodeOutputed.nodes) {
                if (!node.isChecked) {
                    node.isChecked = true;
                    node.count = nodeOutputed.count + 1;
                    queue.add(node);
                }
            }
        }
    }

    private void eachNodeMapping(Node[] nodes, int[][] edge) {
        for (int[] ints : edge) {
            nodes[ints[0]].nodes.add(nodes[ints[1]]);
            nodes[ints[1]].nodes.add(nodes[ints[0]]);
        }
    }

    private void initNodes(Node[] nodes) {
        nodes[0] = new Node(0);
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }


    class Node {
        int value;
        boolean isChecked;
        int count;
        List<Node> nodes = new ArrayList<>();

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", isChecked=" + isChecked +
                    ", nodes=" + nodes.size() +
                    ", count" + count +
                    '}';
        }
    }
}
