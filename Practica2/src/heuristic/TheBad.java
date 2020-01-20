package heuristic;

import structure.State;

// This heuristic looks at the opponent tokens so its "bad"
public class TheBad implements Heuristic {
	@Override
	public float heuristic(State state) {
		return state.count(state.getPlayer1()) - state.count(state.getPlayer2());
	}
}
