package structure;

import java.util.LinkedList;
import java.util.Random;

public class State {

	private DominoToken board;
	private LinkedList<DominoToken> player1;
	private LinkedList<DominoToken> player2;
	private boolean isPlayer1Turn;

	public State(DominoToken board,
				 LinkedList<DominoToken> player1,
				 LinkedList<DominoToken> player2,
				 boolean isPlayer1Turn) {

		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		this.isPlayer1Turn = isPlayer1Turn;
	}

	// Initialization for the beginning of the game.
	// The board is null and the tokens are distributed randomly.
	public State() {
		board = null;
		distributeTokens();
	}

	// This method fill the lists of the players randomly.
	public void distributeTokens() {

		Random random = new Random();
		player1 = new LinkedList<>();
		player2 = new LinkedList<>();
		DominoToken currentToken;
		LinkedList<DominoToken> tokenList = createTokens();

		board = new DominoToken(6, 6);

		for (int i = 0; i < 28; i++) {

			currentToken = tokenList.get(Math.abs(random.nextInt()) % tokenList.size());
			tokenList.remove(currentToken);

			if (i % 2 == 0) {
				if (currentToken.isEqual(board)) isPlayer1Turn = false;
				else player1.add(currentToken);
			}
			else {
				if (currentToken.isEqual(board)) isPlayer1Turn = true;
				else player2.add(currentToken);
			}
		}
	}

	// This method creates a list with the tokens of the game.
	public LinkedList<DominoToken> createTokens() {

		LinkedList<DominoToken> tokenList = new LinkedList<>();
		int right;
		int accum = 0;

		for (int left = 0; left <= 6; left++) {
			right = accum;
			while (right <= 6) {
				tokenList.add(new DominoToken(left, right));
				right++;
			}
			accum++;
		}

		return tokenList;
	}


	// This method returns 0 if the state is not final
	// 1 if is final because one player has no tokens
	// 2 if both players have tokens but these don't fit on the board.
	public int whichFinal() {

		int finalState = 0;

		if (player1.isEmpty() || player2.isEmpty())
			finalState = 1;

		else if (getPossibleMoves(player1).getFirst().usedToken == null &&
				getPossibleMoves(player2).getFirst().usedToken == null)
			finalState = 2;

		return finalState;
	}

	// Returns true if the player1 is the winner.
	public boolean isWinner() {
		return player1.isEmpty() ||
				whichFinal() == 2 && (count(player1) < count(player2));
	}

	// This method counts the number of points of a list of tokens.
	public int count(LinkedList<DominoToken> tokenList) {

		int num = 0;
		for (DominoToken token : tokenList)
			num += token.left + token.right;

		return num;
	}

	public LinkedList<State> getSuccessorList() {

		LinkedList<State> successorList = new LinkedList<>();
		LinkedList<Move> possibleMoves = getPossibleMoves((isPlayer1Turn) ? player1 : player2);

		for (Move move : possibleMoves)
			successorList.add(getSuccessor(move));

		return successorList;
	}

	// This method returns a new state with the given move
	public State getSuccessor(Move move) {
		State newState = new State(board.clone(),
				(LinkedList) player1.clone(),
				(LinkedList) player2.clone(),
				!isPlayer1Turn);
		if (move.usedToken != null) {
			if (isPlayer1Turn) newState.player1.remove(move.usedToken);
			else newState.player2.remove(move.usedToken);

			if (move.isLeftBoard)
				newState.board.left = move.isLeftMine ? move.usedToken.right : move.usedToken.left;
			else newState.board.right = move.isLeftMine ? move.usedToken.right : move.usedToken.left;
		}
		return newState;
	}

	// This method returns a list with all the movements that can be used on the board.
	public LinkedList<Move> getPossibleMoves(LinkedList<DominoToken> playerList) {

		LinkedList<Move> possibleMoveList = new LinkedList<>();

		for (DominoToken token : playerList) {
			if (token.right == board.right)	possibleMoveList.add(new Move(token, false, false));
			if (token.right == board.left)	possibleMoveList.add(new Move(token, false, true));
			if (token.left == board.right)	possibleMoveList.add(new Move(token, true, false));
			if (token.left == board.left)	possibleMoveList.add(new Move(token, true, true));
		}

		if (possibleMoveList.isEmpty())
			possibleMoveList.add(new Move(null, false, false));

		return possibleMoveList;
	}

	// This method returns the number of truncated tokens
	public int getTruncatedTokens(boolean isMyTurn) {

		LinkedList<DominoToken> possibleBoard = new LinkedList<>();
		LinkedList<DominoToken> playerList;
		int numTruncTok = 0;
		int count;

		// Chose player
		if (isPlayer1Turn && !isMyTurn || !isPlayer1Turn && isMyTurn) playerList = player2;
		else playerList = player1;

		// Fill possible board list
		for (DominoToken token : player1) possibleBoard.add(token);
		for (DominoToken token : player2) possibleBoard.add(token);
		possibleBoard.add(board);

		for (DominoToken token : playerList) {

			count = 0;
			possibleBoard.remove(token);

			for (DominoToken board : possibleBoard) {
				if (token.right == board.right || token.right == board.left || token.left == board.right || token.left == board.left)
					count++;
			}

			if (count == 0) numTruncTok++;

			possibleBoard.add(token);
		}

		return numTruncTok;
	}

	public DominoToken getBoard() {
		return board;
	}

	public LinkedList<DominoToken> getPlayer1() {
		return player1;
	}

	public LinkedList<DominoToken> getPlayer2() {
		return player2;
	}

	public boolean isPlayer1Turn() {
		return isPlayer1Turn;
	}

	public String toString() {
		return	"Board:\t" + board
				+ "\nPlayer1:\t" + player1
				+ "\nPlayer2:\t" + player2
				+ "\nIs player1 turn?\t" + isPlayer1Turn;
	}
}