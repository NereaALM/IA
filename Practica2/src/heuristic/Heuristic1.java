package heuristic;

import structure.State;

public class Heuristic1 implements Heuristic {
    @Override
    public float heuristic( State state ) {

        float heuristic;

        // Number of tokens
        float numTokens = state.getMyTokens().size();
        float opNumTokens = state.getOpponentTokens().size();
        heuristic = 0.3f * ( numTokens - opNumTokens );

        // Number of possible tokens
        float possibleTokens = state.getPossibleTokens( state.getMyTokens() ).size();
        float opPossibleTokens = state.getPossibleTokens( state.getOpponentTokens() ).size();
        heuristic += 0.5f * ( possibleTokens - opPossibleTokens );

        // Accumulation of points
        float points = state.count( state.getMyTokens() );
        float opPoints = state.count( state.getOpponentTokens() );
        heuristic += 0.2f * ( points - opPoints );

        return heuristic;
    }
}
