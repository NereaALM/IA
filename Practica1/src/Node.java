import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable< Node > {

    private State state;
    private Node previousNode;
    private int funcValue;


    public Node( State state, Node previousNode, int funcValue ) {

        this.state = state;
        this.previousNode = previousNode;
        this.funcValue = funcValue;
    }

    public int compareTo( Node node ) {

        int result;

        if ( this.funcValue < node.funcValue )
            result = -1;

        else if ( this.funcValue == node.funcValue )
            result = 0;

        else result = 1;

        return result;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public int getFuncValue() {
        return funcValue;
    }

    public void setFuncValue(int funcValue) {
        this.funcValue = funcValue;
    }
}
