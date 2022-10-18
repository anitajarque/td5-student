package fr.ubx.poo.td5.model;

import java.util.List;

public class Node<T> {
    private final T data;
    private final List<Node<T>> neighbours;

    public Node(T data, T data1, List<Node<T>> neighbours) {
        this.data = data1; /* A compléter */
        this.neighbours = neighbours;
    }
    public T getData() { /* A compléter */
        return null;
    }
    public void addEdge(Node to) { /* A compléter */ }
    public List<Node<T>> getNeighbours() { /* A compléter */
        return null;
    }
}
