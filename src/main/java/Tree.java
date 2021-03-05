import unit.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Tree {
    public final ArrayList<Node> tree = new ArrayList<>();
    public final HashMap<String, Integer> unitsToIndex = new HashMap<>();

    public Tree() {
    }

    public void addVertex(String from, String to, Double factor) {
        if (factor < 1){
            var b = from;
            from = to;
            to = b;
            factor = 1 / factor;
        }
        var fromIndex = getIndex(from,factor);
        var node = tree.get(fromIndex);
        var lastNode = getLastNode(node);
        lastNode.nextNode = new Node(factor, null, to);

    }

    private int getIndex(String from, Double factor){
        var i = unitsToIndex.get(from);
        if (i == null) {
            var node = new Node(0, null, from);
            tree.add(node);
            i = tree.size() - 1;
            unitsToIndex.put(from, i);
        }
        return i;
    }

    private Node getLastNode(Node node){
        while (node.nextNode != null){
            node = node.nextNode;
        }
        return node;
    }
}
