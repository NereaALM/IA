import java.util.List;

public class PendingList {

    List< State > pendingList;


    public PendingList()
    {

    }

    public boolean isEmpty()
    {
        return pendingList.isEmpty();
    }

    public State getState()
    {
        int index = 0;
        State State;

        State = pendingList.get( index );

        return State;
    }

    public void addState( State State )
    {
        pendingList.add( State );
    }
}
