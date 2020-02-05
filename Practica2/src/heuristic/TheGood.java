package heuristic;

import structure.DominoToken;
import structure.State;

import java.util.LinkedList;

// The most complete heuristic
public class TheGood implements Heuristic {
	@Override
	public float heuristic(State state) {

		LinkedList<DominoToken> ownTokens = state.isPlayer1Turn()? state.getPlayer1() : state.getPlayer2();
		LinkedList<DominoToken> opTokens = state.isPlayer1Turn()? state.getPlayer2() : state.getPlayer1();

		// Total num of tokens
		int numOwnT = ownTokens.size();
		int numOpT = opTokens.size();

		// Num of tokens similar to board
		int posOwnT = state.getPossibleMoves(ownTokens).size();
		int posOpT = state.getPossibleMoves(opTokens).size();

		// Num of acumm points
		int ownPoints = state.count(ownTokens);
		int opPoints = state.count(opTokens);

		// Num of truncated tokens
		int ownTruncatedT = state.getTruncatedTokens(true);
		int opTruncatedT = state.getTruncatedTokens(false);

		return 4 * (opTruncatedT - ownTruncatedT) + 3 * (numOpT - numOwnT) + 2 * (posOwnT - posOpT) + (opPoints - ownPoints);
	}
}
