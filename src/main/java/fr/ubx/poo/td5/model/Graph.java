package fr.ubx.poo.td5.model;

import java.util.Set;

public class Graph<T> {
    private final Set<Node<T>> nodes;

    public Graph(Set<Node<T>> nodes) {  /* A compléter */
        this.nodes = nodes;
    }
    public void addNode(T data) {  /* A compléter */ }
    public Node<T> getNode(T data) {  /* A compléter */
        return null;
    }
    public Set<Node<T>> getNodes() { /* A compléter */
        return null;
    }

    public boolean isConnected(){
        boolean isConnected=true;
        double[][] nodes = new double[0][0];
        for(int i = 0; i<nodes.length; i++){
            for(int j=0;j<nodes.length;j++){
                if(i!=j && nodes[i][j]==0){
                    isConnected = false;
                    break;
                }
            }
        }
        System.out.println(isConnected);
        return false;
    }
}