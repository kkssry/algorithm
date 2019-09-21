package baekjoon.q1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nodeInfo = br.readLine().split(" ");
        Edge[] edges = new Edge[Integer.parseInt(nodeInfo[1])];
        initEdges(edges, br);
        Arrays.sort(edges);
        int[] nodes = new int[Integer.parseInt(nodeInfo[0]) + 1];
        initNode(nodes);
        startUnion(edges, nodes);
        System.out.println(sum);
    }

    private static void initNode(int[] nodes) {
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = i;
        }
    }

    private static void startUnion(Edge[] edges, int[] nodes) {
        for (Edge edge : edges) {
            union(edge, nodes);
        }
    }

    private static int getParent(int[] nodes, int index) {
        if (nodes[index] == index) {
            return index;
        }
        return nodes[index] = getParent(nodes, nodes[index]);
    }

    private static void union(Edge edgeNodes, int[] nodes) {
        int first = getParent(nodes, edgeNodes.nodes[0]);
        int second = getParent(nodes, edgeNodes.nodes[1]);
        if (first != second) {
            sum += edgeNodes.distance;
        }
        if (first < second) {
            nodes[second] = nodes[first];
        } else {
            nodes[first] = nodes[second];
        }
    }

    private static void initEdges(Edge[] edges, BufferedReader br) throws IOException {
        for (int i = 0; i < edges.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int node3 = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(node1, node2, node3);
        }
    }

    static class Edge implements Comparable<Edge> {
        int[] nodes = new int[2];
        int distance;

        Edge(int node1, int node2, int instance) {
            this.nodes[0] = node1;
            this.nodes[1] = node2;
            this.distance = instance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(distance, o.distance);
        }
    }
}
