package heuristic;

import structure.DominoToken;
import structure.Move;
import structure.State;

import java.util.LinkedList;

// The idea of avoiding the double tokens is dodging the possibility of truncated pieces
public class TheUgly implements Heuristic {
	@Override
	public float heuristic(State state) {

		LinkedList<DominoToken> ownTokens = state.isPlayer1Turn()? state.getPlayer1() : state.getPlayer2();
		LinkedList<DominoToken> opTokens = state.isPlayer1Turn()? state.getPlayer2() : state.getPlayer1();

		int ownDouble = 0;
		LinkedList<Move> ownMoves = state.getPossibleMoves(ownTokens);
		for (Move move : ownMoves)
			if (move.usedToken.left == move.usedToken.right)
				ownDouble++;

		int opDouble = 0;
		LinkedList<Move> opMoves = state.getPossibleMoves(opTokens);
		for (Move move : opMoves)
			if (move.usedToken.left == move.usedToken.right)
				opDouble++;

		return opDouble - ownDouble;
	}
}