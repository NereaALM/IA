package heuristic;

import structure.State;

public class Heuristic1 implements Heuristic {
    @Override
    public float heuristic( State state ) {

        float heuristic;

        // Number of tokens
        float numTokens = state.getPlayer1().size();
        float opNumTokens = state.getPlayer2().size();
        heuristic = 0.3f * ( numTokens - opNumTokens );

        // Number of possible tokens
        float possibleTokens = state.getPossibleTokens( state.getPlayer1() ).size();
        float opPossibleTokens = state.getPossibleTokens( state.getPlayer2() ).size();
        heuristic += 0.5f * ( possibleTokens - opPossibleTokens );

        // Accumulation of points
        float points = state.count( state.getPlayer1() );
        float opPoints = state.count( state.getPlayer2() );
        heuristic += 0.2f * ( points - opPoints );

        return heuristic;
    }
}
