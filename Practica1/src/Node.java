import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable< Node >{

    private State state;
    private List< Node > way;
    private int funcValue;
    private List< Node > successorList;

    public Node( State state, List< Node > way, int funcValue ) {

        this.state = state;
        this.way = way;
        this.funcValue = funcValue;
        successorList = new ArrayList<>();
    }

    public int compareTo( Node node ) {
        int result;

        if ( funcValue < node.funcValue )
            result = -1;
        else if ( funcValue == node.funcValue )
            result = 0;
        else
            result = 1;

        return result;
    }


    public State getState() {
        return state;
    }

    public void setState( State state ) {
        this.state = state;
    }

    public List< Node > getWay() {
        return way;
    }

    public void setWay( List< Node > way ) {
        this.way = way;
    }

    public int getFuncValue() {
        return funcValue;
    }

    public void setFuncValue( int funcValue ) {
        this.funcValue = funcValue;
    }

    public List< Node > getSuccessorList() {
        return successorList;
    }

    public void setSuccessorList( List< Node > successorList ) {
        this.successorList = successorList;
    }
}
