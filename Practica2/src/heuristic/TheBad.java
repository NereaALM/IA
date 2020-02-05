package heuristic;

import structure.DominoToken;
import structure.State;

import java.util.LinkedList;

// This heuristic looks at the opponent tokens so its "bad"
public class TheBad implements Heuristic {
	@Override
	public float heuristic(State state) {

		LinkedList<DominoToken> opTokens = state.isPlayer1Turn()? state.getPlayer2() : state.getPlayer1();

		// Total num of tokens
		int numOpT = opTokens.size();

		// Num of tokens similar to board
		int posOpT = state.getPossibleMoves(opTokens).size();

		return numOpT - posOpT / 2f;
	}
}
