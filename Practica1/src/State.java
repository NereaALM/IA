import java.util.ArrayList;
import java.util.List;

public class State {
    private int row;
    private int column;
    private int roadType;
    private List< State > successorList;

    public State( int r, int c, int roadT ) {
        row = r;
        column = c;
        roadType = roadT;
        successorList = new ArrayList< State >();
    }

    public List< State > getSuccessorList() {
        return successorList;
    }
}
