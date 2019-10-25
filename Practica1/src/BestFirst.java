import java.util.Collections;

public class BestFirst extends SearchingAlgorithm {

    public BestFirst() {}

    public void addPending( Node node ) {

        // The BF objective is being fast finding a way so repeated nodes are ignored.
        // !pendingList.contains( node.getState ) )
        // TO DO: Maybe the solutions is worst than the problem in cost.
        boolean foundEqual = false;

        for ( Node auxNode : pendingList )
            if ( auxNode.getState().equals( node.getState() ) )
                foundEqual = true;

        if ( !foundEqual ) {
            pendingList.add( node );
            Collections.sort( pendingList );
        }
    }

    public Node getPending() {

        int pos = 0;
        Node node = pendingList.get( pos );

        pendingList.remove( node );
        Collections.sort( pendingList );

        return node;
    }

    public int getFuncValue( State currentState, State finalState ) {
        return heuristic.distance( currentState, currentState );
    }
}
