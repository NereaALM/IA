import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class SearchingAlgorithm {

    protected Heuristic heuristic;
    protected List < Node > pendingList;
    protected HashMap < Integer, State > treatedMap;
    protected List < Node > way;

    public SearchingAlgorithm() {

        heuristic = new Heuristic();
        pendingList = new ArrayList<>();
        treatedMap = new HashMap<>();
        way = new ArrayList<>();
    }


    public List< Node > Search( State iniState, State finalState ) {

        Node previousNode = null;
        Node currentNode = new Node( iniState, previousNode, getFuncValue() );
        boolean found = false;


        addPending( currentNode );

        while ( !found && !pendingList.isEmpty() ) {

            currentNode = getPending();

            if( currentNode.getState().equals( finalState ) )
                found = true;

            else {

                for ( State state : currentNode.getState().getSuccessorList() )
                    if( !treatedMap.containsValue( state ) ) {

                        Node newNode = new Node( state, currentNode, getFuncValue() );
                        addPending( newNode );
                    }

                treatedMap.put( currentNode.getState().hashCode(), currentNode.getState() );
            }
        }

        // TO DO:

        if( !found ) way = null;

        else {

            Node node = currentNode;

            while( node != null ) {

                way.add( currentNode );
                currentNode = currentNode.getPreviousNode();
            }
        }

        return way;
    }


    public List<Node> getWay() {
        return way;
    }

    public int getWayCost( List< Node > way ) {

        int cost = 0;

        for ( Node node : way ) {
            cost += node.getFuncValue();
        }

        return cost;
    }


    public abstract void addPending( Node node );

    public abstract Node getPending();

    public abstract int getFuncValue();
}