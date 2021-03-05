package unit;

public class Node {
    public final double factor;
    public final String name;
    public Node nextNode;

    public Node(double factor, Node nextNode, String name) {
        this.factor = factor;
        this.nextNode = nextNode;
        this.name = name;
    }
}

