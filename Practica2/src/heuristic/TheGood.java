package heuristic;

import structure.State;

public class TheGood implements Heuristic {
    @Override
    public float heuristic (State state) {

        float heuristic = 0;

        // Number of tokens
        int ownTokens = state.getPlayer1().size();
        int opTokens = state.getPlayer2().size();

        // Number of possible tokens for the board
        int posOwnTokens = state.getPossibleTokens(state.getPlayer1()).size();
        int posOpTokens = state.getPossibleTokens(state.getPlayer2()).size();

        // Number of sum of the tokens
        int ownSum = state.count(state.getPlayer1());
        int opSum = state.count(state.getPlayer2());

        

        return heuristic;
    }
}
