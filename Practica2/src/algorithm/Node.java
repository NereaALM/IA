package algorithm;

import structure.State;

public class Node {

    private State state;
    private float heuristic;

    public Node( State state, float heuristic ) {
        this.state = state;
        this.heuristic = heuristic;
    }

    public float getHeuristic() {
        return heuristic;
    }

    public void setHeuristic( float heuristic ) {
        this.heuristic = heuristic;
    }

    public State getState() {
        return state;
    }

    public void setState( State state ) {
        this.state = state;
    }
}
