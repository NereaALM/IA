import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AStar {

    protected Heuristic heuristic;
    protected List< NodeAStar > pendingList;
    protected HashMap< Integer, State > treatedMap;
    protected List < NodeAStar > way;

    public AStar() {

        pendingList = new ArrayList<>();
        heuristic = new Heuristic();
        treatedMap = new HashMap<>();
    }


    public List< NodeAStar > Search( State iniState, State finalState ) {

        NodeAStar previousNode = null;
        NodeAStar currentNode = new NodeAStar( iniState, previousNode, heuristic.distance( iniState, finalState ), iniState.getRoadType() );
        boolean found = false;
        addPending( currentNode );


        while ( !found && !pendingList.isEmpty() ) {

            currentNode = getPending();

            if( currentNode.getState().equals( finalState ) )
                found = true;

            else {

                for ( State state : currentNode.getState().getSuccessorList() )
                    if( !treatedMap.containsValue( state ) ) {

                        NodeAStar newNode = new NodeAStar( state, currentNode, heuristic.distance( state, finalState ), state.getRoadType() );
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

    public int getWayCost( List< NodeAStar > way ) {

        int cost = 0;

        for ( NodeAStar node : way )
            cost += node.getHeuristic();

        return cost;
    }


    public void addPending(NodeAStar node) {

        // In order to find an optimum result and knowing that the heuristic is
        // not necessary true, in case of repeated nodes we save both.
        pendingList.add(node);
        Collections.sort(pendingList);
    }

    public NodeAStar getPending() {

        int pos = 0;
        NodeAStar node = pendingList.get(pos);

        pendingList.remove(node);
        Collections.sort(pendingList);

        return node;
    }
}
