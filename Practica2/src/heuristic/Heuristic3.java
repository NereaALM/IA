package heuristic;

import structure.State;

public class Heuristic3 implements Heuristic {
    @Override
    public float heuristic( State state ) {
        return  state.getPossibleTokens( state.getMyTokens() ).size()
                - state.getPossibleTokens( state.getOpponentTokens() ).size();
    }
}
