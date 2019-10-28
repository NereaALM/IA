
public class NodeAStar implements Comparable< NodeAStar >{


    private State state;
    private NodeAStar previousNode;
    private int heuristic;
    private int accumCost;

    public NodeAStar( State state, NodeAStar previousNode, int heuristic, int currentCost ) {

        this.state = state;
        this.previousNode = previousNode;
        this.heuristic = heuristic;
        accumCost = getAccumCost( currentCost );
    }

    public int compareTo( NodeAStar node ) {

        int result;

        if ( this.getFunction() < node.getFunction())
            result = -1;

        else if ( this.getFunction() == node.getFunction())
            result = 0;

        else result = 1;

        return result;
    }


    public int getAccumCost( int accumCost ) {

        if( previousNode != null )
            accumCost += previousNode.getAccumCost( accumCost );

        return accumCost;
    }

    public int getFunction() {
        return heuristic + accumCost;
    }


    public State getState() {
        return state;
    }

    public NodeAStar getPreviousNode() {
        return previousNode;
    }
}