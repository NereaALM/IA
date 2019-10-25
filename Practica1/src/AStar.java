import java.util.Collections;

public class AStar extends SearchingAlgorithm {

    // TO DO: Update accumCost.
    private int accumCost;

    public AStar() {

        accumCost = 0;
    }

    public void addPending( Node node ) {

        // In order to find an optimum result and knowing that the heuristic is
        // not necessary true, in case of repeated nodes we save both.
        pendingList.add( node );
        Collections.sort( pendingList );
    }

    public Node getPending() {

        int pos = 0;
        Node node = pendingList.get( pos );

        pendingList.remove( node );
        Collections.sort( pendingList );

        return node;
    }

    public int getFuncValue( State currentState, State finalState ) {

        return accumCost + heuristic.distance( currentState, finalState );
    }
}
