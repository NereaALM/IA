import java.util.HashMap;

public class SearchingAlgorithm
{
    PendingStructure pendingStates;
    HashMap < Integer, State > treatedStates;


    public SearchingAlgorithm()
    {
        pendingStates = new PendingStructure();
        treatedStates = new HashMap<>();
    }

    public boolean Search( State iniState, State finalState )
    {
        boolean found;
        State currentState;


        pendingStates.addState( iniState );
        found = false;

        while ( !found && !pendingStates.isEmpty() )
        {
            // Aquest metode dependrà de l'algorisme.
            currentState = pendingStates.getState(0);
            
            if( currentState.equals( finalState ) )
            {
                found = true;
            }
            else
            {
                for ( State state : currentState.getSuccessorStates() )
                {
                    // Aquesta condició dependrà de l'algorisme.
                    if( !treatedStates.containsValue( state ) && !pendingStates.containsValue( state ) )
                    {
                        // Aquest metode dependrà de l'algorisme.
                        pendingStates.addState( state );
                    }
                }

                treatedStates.put( currentState.getId(), currentState );
            }
        }

        return found;
    }
}
