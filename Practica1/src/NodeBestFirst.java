
public class NodeBestFirst implements Comparable< NodeBestFirst > {

    private State state;
    private NodeBestFirst previousNode;
    private int heuristic;


    public NodeBestFirst(State state, NodeBestFirst previousNode, int heuristic) {

        this.state = state;
        this.previousNode = previousNode;
        this.heuristic = heuristic;
    }

    public int compareTo(NodeBestFirst node) {

        int result;

        if (this.heuristic < node.heuristic)
            result = -1;

        else if (this.heuristic == node.heuristic)
            result = 0;

        else result = 1;

        return result;
    }


    // Getters and setters:
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public NodeBestFirst getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(NodeBestFirst previousNode) {
        this.previousNode = previousNode;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }
}
