package fr.ubx.poo.td5.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph<T> {
    private final Set<Node<T>> nodes;

    public Graph() {  /* A compléter */
        this.nodes = new HashSet<Node<T>>();
    }
    public void addNode(T data) {  /* A compléter */
        Node node = new Node(data); //ese data es el de T de esta clase
        nodes.add(node);
    }
    public Node<T> getNode(T data) {  /* A compléter */
        Iterator value = nodes.iterator();
        while(value.hasNext()){
            Node node= (Node) value.next();
            if(node.getData()==data){
                return node;
            }
        }
        return null;
    }
    public Set<Node<T>> getNodes() { /* A compléter */
        return nodes;
    }

    public boolean isConnected() {
        ArrayList<Node> processed = new ArrayList<Node>();
        ArrayList<Node>  procesing = new ArrayList<Node>();
        procesing.add(nodes.iterator().next());
        Node node;
        while(!procesing.isEmpty()){
            node=procesing.remove(0);
            for(int i =0; i<node.getNeighbours().size(); i++){
                if(!procesing.contains(node.getNeighbours().get(i)) && !processed.contains(node.getNeighbours().get(i))){
                    procesing.add((Node) node.getNeighbours().get(i));
                }
            }
        }
        if(processed.size()==nodes.size()){
            return true;
        }
        return false;
    }
}