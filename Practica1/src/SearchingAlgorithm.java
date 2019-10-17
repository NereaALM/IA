import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchingAlgorithm
{
    public SearchingAlgorithm() {}

    public boolean Search( State iniState, State finalState )
    {
        List < State > pendingList;
        HashMap < Integer, State > treatedMap;
        State currentState;
        boolean found;

        pendingList = new ArrayList<>();
        treatedMap = new HashMap<>();
        pendingList.add( iniState );
        found = false;

        while ( !found && !pendingList.isEmpty() )
        {
            currentState = pendingList.get( 0 );
            
            if( currentState.equals( finalState ) )
                found = true;

            else
            {
                for ( State state : currentState.getSuccessorList() )
                {
                    if( !treatedMap.containsValue( state ) && !pendingList.contains( state ) )
                        pendingList.add( state );
                }
                treatedMap.put( currentState.hashCode(), currentState );
            }
        }
        return found;
    }
}