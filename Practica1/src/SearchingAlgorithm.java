import java.util.HashMap;

public class SearchingAlgorithm
{
    public SearchingAlgorithm()
    {

    }

    public boolean Search( State iniState, State finalState )
    {
        boolean found;
        State currentState;
        PendingList pendingList = new PendingList();
        HashMap < Integer, State > treatedMap = new HashMap<>();

        pendingList.addState( iniState );
        found = false;

        while ( !found && !pendingList.isEmpty() )
        {
            currentState = pendingList.getState();
            
            if( currentState.equals( finalState ) )
            {
                found = true;
            }
            else
            {
                for ( State state : currentState.successorList )
                {
                    if( !treatedMap.containsValue( state ) && !pendingList.containsValue( state ) )
                    {
                        pendingList.addState( state );
                    }
                }

                treatedMap.put( treatedMap.hashCode(), currentState );
            }
        }

        return found;
    }
}
