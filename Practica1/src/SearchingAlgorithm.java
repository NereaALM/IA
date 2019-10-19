import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class SearchingAlgorithm {

    protected List < Node > pendingList;
    protected HashMap < Integer, State > treatedMap;
    protected Heuristic heuristic;

    public SearchingAlgorithm() {

        pendingList = new ArrayList<>();
        treatedMap = new HashMap<>();
        heuristic = new Heuristic();
    }

    public List< Node > Search( State iniState, State finalState ) {

        List < Node > way = new ArrayList<>();
        Node currentNode = new Node( iniState, way, getFuncValue() );
        boolean found = false;


        addNode( currentNode );

        while ( !found && !pendingList.isEmpty() ) {

            currentNode = getNode();

            if( currentNode.getState().equals( finalState ) )
                found = true;

            else {

                for ( Node node : currentNode.getSuccessorList() )
                    if( !treatedMap.containsValue( node.getState() ) )
                        addNode( node );
                treatedMap.put( currentNode.getState().hashCode(), currentNode.getState() );
            }
        }

        way = currentNode.getWay();
        if( !found ) way = null;

        return way;
    }

    public abstract void addNode( Node node );

    public abstract Node getNode();

    public abstract int getFuncValue();

}