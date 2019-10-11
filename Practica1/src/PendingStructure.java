import java.util.List;

public class PendingStructure {

    List< State > pendingList;


    public PendingStructure()
    {
    }

    public boolean isEmpty()
    {
        return pendingList.isEmpty();
    }

    public State getState( int index )
    {
        return pendingList.get( index );
    }

    public void addState( State State )
    {
        pendingList.add( State );
    }

    public boolean containsValue( State state )
    {
        return pendingList.contains( state );
    }
}
