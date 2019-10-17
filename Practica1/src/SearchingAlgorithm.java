import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchingAlgorithm {

    public SearchingAlgorithm() {}

    public int Search( State iniState, State finalState ) {

        List < State > pendingList = new ArrayList<>();
        HashMap < Integer, State > treatedMap = new HashMap<>();
        State currentState;
        int way = 0;
        int heuristic;
        boolean found = false;


        pendingList.add( iniState );

        while ( !found && !pendingList.isEmpty() ) {

            currentState = pendingList.get( 0 );
            
            if( currentState.equals( finalState ) )
                found = true;

            else {
                for ( State state : currentState.getSuccessorList() )
                    if( !treatedMap.containsValue( state ) && !pendingList.contains( state ) )
                        pendingList.add( state );

                treatedMap.put( currentState.hashCode(), currentState );
            }
        }

        if( !found ) way = -1;

        return way;
    }
}