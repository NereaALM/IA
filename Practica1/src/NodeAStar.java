
public class NodeAStar implements Comparable< NodeAStar >{


    private State state;
    private NodeAStar previousNode;
    private int heuristic;
    private int accumCost;

    public NodeAStar( State state, NodeAStar previousNode, int heuristic, int accumCost ) {

        this.state = state;
        this.previousNode = previousNode;
        this.heuristic = heuristic;
        this.accumCost = accumCost;
    }

    public int compareTo( NodeAStar NodeAStar ) {

        int result;

        if ( this.heuristic < NodeAStar.heuristic)
            result = -1;

        else if ( this.heuristic == NodeAStar.heuristic)
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

    public NodeAStar getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(NodeAStar previousNode) {
        this.previousNode = previousNode;
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public int getAccumCost() {

        if( previousNode != null )
            accumCost += previousNode.getAccumCost();

        return accumCost;
    }
}