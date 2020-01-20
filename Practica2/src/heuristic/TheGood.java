package heuristic;

import structure.State;

// The most complete heuristic
public class TheGood implements Heuristic {
	@Override
	public float heuristic(State state) {

		float heuristic = 0;

		// Total num of tokens
		int ownTokens = state.getPlayer1().size();
		int opTokens = state.getPlayer2().size();

		// Num of tokens similar to board
		int posOwnT = state.getPossibleMoves(state.getPlayer1()).size();
		int posOpT = state.getPossibleMoves(state.getPlayer1()).size();

		// Num of acumm points
		int ownPosT = state.count(state.getPlayer1());
		int opPosT = state.count(state.getPlayer2());


		heuristic = (ownTokens - opTokens) + (posOwnT - posOpT) + (ownPosT - opPosT);

		return heuristic;
	}
}
