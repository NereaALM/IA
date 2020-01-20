package heuristic;

import structure.State;

// This one is just ugly
public class TheUgly implements Heuristic {
	@Override
	public float heuristic(State state) {
		return state.getPossibleMoves(state.getPlayer1()).size()
				- state.getPossibleMoves(state.getPlayer2()).size();
	}
}
