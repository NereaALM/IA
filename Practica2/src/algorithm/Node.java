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

    public State getState() {
        return state;
    }
}
