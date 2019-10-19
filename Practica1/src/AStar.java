import java.util.Collections;

public class AStar extends SearchingAlgorithm {

    private int g;
    public AStar() {}

    public void addNode( Node node ) {

        // In order to find an optimum result and knowing that the heuristic is
        // not necessary true, in case of repeated nodes we save both.
        pendingList.add( node );
        Collections.sort( pendingList );
    }

    public Node getNode() {

        int pos = 0;
        Node node = pendingList.get( pos );

        pendingList.remove( node );
        Collections.sort( pendingList );

        return node;
    }

    public int getFuncValue() {
        return g + heuristic.heuristicA();
    }
}
