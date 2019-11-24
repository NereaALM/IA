package heuristic;

import structure.State;

public class Heuristic2 implements Heuristic {
    @Override
    public float heuristic( State state ) {
        return state.count( state.getMyTokens() ) - state.count( state.getOpponentTokens() );
    }
}
