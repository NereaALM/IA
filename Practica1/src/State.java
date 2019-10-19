
public class State {

    private int row;
    private int column;
    private int roadType;

    public State( int r, int c, int roadT ) {

        row = r;
        column = c;
        roadType = roadT;
    }

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
