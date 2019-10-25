package programmers.q12978;

import java.util.*;

public class Solution {
    public int solution(int N, int[][] road, int K) {
        Node[] nodes = new Node[N + 1];
        initNodes(nodes);
        initNodesProperty(nodes, road);
        saveResult(nodes[1],  K);
        System.out.println(Arrays.toString(nodes));
        return countCheckedNode(nodes, K);
    }

    private void initNodes(Node[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
    }

    private int countCheckedNode(Node[] nodes, int K) {
        int count = 0;
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].accretedDistance <= K) {
                count++;
            }
        }
        return count;
    }

    private void saveResult(Node node, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        node.accretedDistance = 0;

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (int i = 0; i < currentNode.nodes.size(); i++) {
                Node targetNode = currentNode.nodes.get(i);
                int targetDistance = currentNode.distances.get(i) + currentNode.accretedDistance;

                 if (targetDistance <= k && targetNode.accretedDistance > targetDistance ) {
                     targetNode.accretedDistance = targetDistance;
                     queue.add(targetNode);
                }
            }
        }

    }

    private void initNodesProperty(Node[] nodes, int[][] road) {
        for (int[] ints : road) {
            int nodeNum = ints[0];
            int nodeNum2 = ints[1];
            int distance = ints[2];

            nodes[nodeNum].nodes.add(nodes[nodeNum2]);
            nodes[nodeNum2].nodes.add(nodes[nodeNum]);

            nodes[nodeNum].distances.add(distance);
            nodes[nodeNum2].distances.add(distance);
        }
    }

    static class Node {
        int number;
        List<Node> nodes = new ArrayList<>();
        List<Integer> distances = new ArrayList<>();
        int accretedDistance = 500001;

        Node(int number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "accretedDistance=" + accretedDistance +
                    '}';
        }
    }

}
