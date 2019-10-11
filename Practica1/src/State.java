import java.util.LinkedList;
import java.util.List;

public class State
{
    private int id;
    private int posR;
    private int posC;
    private int roadType;
    private List< State > successorStates;


    public State( int posR, int posC, int roadType, int size )
    {
        this.posR = posR;
        this.posC = posC;
        this.roadType = roadType;
        setId( size );
        successorStates = new LinkedList<>();
        fillSuccessorList();
    }

    private void setId( int size )
    {
        id = size * posC + posR;
    }

    private void fillSuccessorList()
    {
        int up;
        int down;
        int left;
        int right;

        // TO DO:
    }

    // Getters:

    public int getId() {
        return id;
    }

    public int getPosR()
    {
        return posR;
    }

    public int getPosC()
    {
        return posC;
    }

    public int getRoadType() {
        return roadType;
    }

    public List< State > getSuccessorStates() {
        return successorStates;
    }

}
