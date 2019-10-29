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
        successorList = new ArrayList<>();
    }

    public String toString() {
        return " Position: " + column + " " + row + "\tCost:" + roadType;
    }

    // Successor list methods:
    public List<State> getSuccessorList() {
        return successorList;
    }

    public void addSuccessor( State state ) {
        successorList.add( state );
    }


    // Getters:
    public int getRoadType() {
        return roadType;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
