import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AStar {

    protected List< NodeAStar > pendingList;
    protected HashMap< Integer, State > treatedMap;
    protected List < NodeAStar > way;
    protected Heuristic heuristic;

    public AStar() {

        pendingList = new ArrayList<>();
        treatedMap = new HashMap<>();
        heuristic = new Heuristic();
    }


    public List< NodeAStar > Search( State iniState, State finalState ) {

        NodeAStar previousNode = null;
        NodeAStar currentNode = new NodeAStar( iniState, previousNode, heuristic.roadType(iniState), iniState.getRoadType() );
        boolean found = false;
        addPending( currentNode );


        while ( !found && !pendingList.isEmpty() ) {

            currentNode = getPending();

            if( currentNode.getState().equals( finalState ) ) {

                found = true;

                // Creation of the way list.
                way = new ArrayList<>();

                while( currentNode != null ) {

                    way.add( currentNode );
                    currentNode = currentNode.getPreviousNode();
                }

                Collections.reverse( way );
            }
            else {

                for ( State state : currentNode.getState().getSuccessorList() )
                    if( !treatedMap.containsValue( state ) ) {

                        NodeAStar newNode = new NodeAStar( state, currentNode,  heuristic.roadType(state) , state.getRoadType() );
                        addPending( newNode );
                    }

                treatedMap.put( currentNode.getState().hashCode(), currentNode.getState() );
            }
        }

        return way;
    }

    public int getWayCost( List< NodeAStar > way ) {

        int cost = 0;

        int costInitalNode = way.get( 0 ).getState().getRoadType();

        for ( NodeAStar node : way )
            cost += node.getState().getRoadType();

        return cost - costInitalNode;
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
