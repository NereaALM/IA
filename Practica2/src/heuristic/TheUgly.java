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
		for (DominoToken token : ownTokens)
			if (token.left == token.right)
				ownDouble++;

		int opDouble = 0;
		for (DominoToken token : opTokens)
			if (token.left == token.right)
				opDouble++;

		return opDouble - ownDouble;
	}
}