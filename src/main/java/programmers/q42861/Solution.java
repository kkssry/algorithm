package programmers.q42861;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int[][] costs) {
        int[] nodeNumber = new int[n];
        initNodeNumber(nodeNumber);
        Node[] nodeManager = new Node[costs.length];
        initNodeManager(nodeManager, costs);
        Arrays.sort(nodeManager);
        return startConnect(nodeNumber, nodeManager);
    }

    private int startConnect(int[] nodeNumber, Node[] nodeManager) {
        int costSum = 0;
        for (Node node : nodeManager) {
            int root1 = findRoot(nodeNumber, node.value1);
            int root2 = findRoot(nodeNumber, node.value2);
            if (root1 != root2) {
                costSum += node.cost;
            }
            if (root1 < root2) {
                nodeNumber[root2] = nodeNumber[root1];
            }
            if (root1 > root2) {
                nodeNumber[root1] = nodeNumber[root2];
            }
        }
        return costSum;
    }

    private int findRoot(int[] nodeNumber, int index) {
        if (nodeNumber[index] == index) {
            return index;
        }
        return nodeNumber[index] = findRoot(nodeNumber, nodeNumber[index]);
    }

    private void initNodeManager(Node[] nodeManager, int[][] costs) {
        for (int i = 0; i < nodeManager.length; i++) {
            nodeManager[i] = new Node(costs[i][0], costs[i][1], costs[i][2]);
        }
    }

    private void initNodeNumber(int[] nodeNumber) {
        for (int i = 0; i < nodeNumber.length; i++) {
            nodeNumber[i] = i;
        }
    }

    static class Node implements Comparable<Node> {
        int value1;
        int value2;
        int cost;

        Node(int value1, int value2, int cost) {
            this.value1 = value1;
            this.value2 = value2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
}
