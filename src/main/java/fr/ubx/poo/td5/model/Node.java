package fr.ubx.poo.td5.model;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
    private final T data;
    private final List<Node<T>> neighbours;

    public Node(T data) {
        this.data = data;
        /* A compléter */
        neighbours = new ArrayList<Node<T>>(); //al tener list hacer arrayList para evitar conflictos al ser interfaz
    }
    public T getData() { /* A compléter */
        return data;
    }
    public void addEdge(Node to) { /* A compléter */
        neighbours.add(to);
    }
    public List<Node<T>> getNeighbours() { /* A compléter */
        return neighbours;
    }
}
