public class Node {

    private State state;
    private int heuristic;

    public Node( int heuristic ) {
        this.heuristic = heuristic;
        state = new State();
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic( int heuristic ) {
        this.heuristic = heuristic;
    }

    public State getState() {
        return state;
    }

    public void setState( State state ) {
        this.state = state;
    }
}
