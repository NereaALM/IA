import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BestFirst {


    protected Heuristic heuristic;
    protected List < NodeBestFirst > pendingList;
    protected HashMap< Integer, State > treatedMap;
    protected List < NodeBestFirst > way;

    public BestFirst() {

        pendingList = new ArrayList<>();
        heuristic = new Heuristic();
        treatedMap = new HashMap<>();
    }


    public List< NodeBestFirst > Search(State iniState, State finalState ) {

        NodeBestFirst previousNode = null;
        NodeBestFirst currentNode = new NodeBestFirst( iniState, previousNode, heuristic.distance( iniState, finalState ) );
        boolean found = false;
        addPending( currentNode );


        while ( !found && !pendingList.isEmpty() ) {

            currentNode = getPending();

            if( currentNode.getState().equals( finalState ) )
                found = true;

            else {

                for ( State state : currentNode.getState().getSuccessorList() )
                    if( !treatedMap.containsValue( state ) ) {

                        NodeBestFirst newNode = new NodeBestFirst( state, currentNode, heuristic.distance( state, finalState ) );
                        addPending( newNode );
                    }

                treatedMap.put( currentNode.getState().hashCode(), currentNode.getState() );
            }
        }


        if( !found ) way = null;

        else {


            way = new ArrayList<>();

            while( currentNode != null ) {

                way.add( currentNode );
                currentNode = currentNode.getPreviousNode();
            }
        }

        return way;
    }

    public int getWayCost( List< NodeBestFirst > way ) {

        int cost = 0;

        for ( NodeBestFirst node : way )
            cost += node.getHeuristic();

        return cost;
    }


    public void addPending( NodeBestFirst node ) {

        boolean foundEqual = false;

        // The BF objective is being fast finding a way so repeated nodes are ignored.
        for ( NodeBestFirst auxNode : pendingList )
            if ( auxNode.getState().equals( node.getState() ) )
                foundEqual = true;

        if ( !foundEqual ) {

            pendingList.add( node );
            Collections.sort( pendingList );
        }
    }

    public NodeBestFirst getPending() {

        int pos = 0;
        NodeBestFirst node = pendingList.get( pos );

        pendingList.remove( node );
        Collections.sort( pendingList );

        return node;
    }
}
