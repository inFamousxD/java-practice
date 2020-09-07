package graphs.practice;

import java.util.*;

public class AdjacencyList {
    private final Map<Integer, Node> nodes = new HashMap<>();
    private final Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public static class Node {
        int id;
        public Node (int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return Integer.toString(this.id);
        }
    }

    public void addEdge(int from, int to) {
        var fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(toNode);
        adjacencyList.get(toNode).add(fromNode);
    }

    public void createNode(int id) {
        Node node = new Node(id);
        nodes.putIfAbsent(id, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void print() {
        for (Node node : adjacencyList.keySet()) {
            var n = adjacencyList.get(node);
            System.out.println(node + "->" + n);
        }
    }

    public void rebuild(int libMult, int roadMult) {
        Set<Node> visited = new HashSet<>();
        int lib = 0;
        int road = 0;
        for (Node node : adjacencyList.keySet()) {
            if (!visited.contains(node)) {
                visited.add(node);
                visited.addAll(adjacencyList.get(node));
                lib += 1;
                road += adjacencyList.get(node).size();
            }
        }
        if (libMult > roadMult)
            System.out.println(lib*libMult + " " + road*roadMult);
        else
            System.out.println(libMult*nodes.size());
    }

    public static void main(String[] args) {
        AdjacencyList o = new AdjacencyList();
        for (int i = 1; i <= 6; i++)
            o.createNode(i);
        o.addEdge(1, 2);
        o.addEdge(2, 3);
        o.addEdge(1, 3);
        o.addEdge(4, 5);
        o.addEdge(5, 6);
        o.addEdge(4, 6);
        o.print();

        o.rebuild(2, 1);
    }
}
