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
            currentState = pendingList.getState(0);
            
            if( currentState.equals( finalState ) )
            {
                found = true;
            }
            else
            {
                for ( State state : currentState.successorList )
                {
                    // La segona condicio es opcional i depen del cas.
                    if( !treatedMap.containsValue( state ) && !pendingList.containsValue( state ) )
                    {
                        pendingList.addState( state );
                    }
                }

                treatedMap.put( currentState.id, currentState );
            }
        }

        return found;
    }
}
