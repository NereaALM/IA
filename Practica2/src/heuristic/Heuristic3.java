package heuristic;

import structure.State;

public class Heuristic3 implements Heuristic {
    @Override
    public float heuristic( State state ) {
        return  state.getPossibleTokens( state.getPlayer1() ).size()
                - state.getPossibleTokens( state.getPlayer2() ).size();
    }
}
