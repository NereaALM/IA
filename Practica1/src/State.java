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


    // Successor list methods:
    public List<State> getSuccessorList() {
        return successorList;
    }

    public void setSuccessorList(List<State> successorList) {
        this.successorList = successorList;
    }

    public State getSuccessor( int index ) {
        return successorList.get( index );
    }

    public void addSuccessor( State state ) {
        successorList.add( state );
    }

    public void setSuccessor( int index, State state ) {
        successorList.set( index, state );
    }


    // Getters and setters:
    public int getRoadType() {
        return roadType;
    }

    public void setRoadType( int roadType ) {
        this.roadType = roadType;
    }

    public int getRow() {
        return row;
    }

    public void setRow( int row ) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn( int column ) {
        this.column = column;
    }
}
