
public class NodeAStar implements Comparable< NodeAStar >{

    private State state;
    private NodeAStar previousNode;
    private int heuristic;
    private int accumCost;

    public NodeAStar( State state, NodeAStar previousNode, int heuristic ) {

        this.state = state;
        this.previousNode = previousNode;
        this.heuristic = heuristic;
        accumCost = getAccumCost( 0 );
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

        accumCost += this.state.getRoadType();

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