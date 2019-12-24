package heuristic;

import structure.State;

public class Heuristic2 implements Heuristic {
    @Override
    public float heuristic( State state ) {
        return state.count( state.getPlayer1() ) - state.count( state.getPlayer2() );
    }
}
