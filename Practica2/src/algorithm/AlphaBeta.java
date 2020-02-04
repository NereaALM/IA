package algorithm;

import heuristic.Heuristic;
import structure.State;

import java.util.LinkedList;

public class AlphaBeta implements GameAlgorithm {

	private Heuristic heuristic;
	private int maxExpLevel;
	private boolean isPlayer1;

	public AlphaBeta(int maxExpLevel, Heuristic heuristic, boolean isPlayer1) {
		this.maxExpLevel = maxExpLevel;
		this.heuristic = heuristic;
		this.isPlayer1 = isPlayer1;
	}

	@Override
	public Node gameAlgorithm(Node currentNode, int currentLevel) {
		return alphaBeta(currentNode, currentLevel, -Float.MAX_VALUE, Float.MAX_VALUE);
	}

	public Node alphaBeta(Node currentNode, int currentLevel, float alpha, float beta) {

		Node result = new Node(null, 0);

		if (currentNode.getState().whichFinal() != 0) {
			if (currentNode.getState().isWinner() == isPlayer1)
				result = new Node(null, Float.MAX_VALUE);
			else result = new Node(null, -Float.MAX_VALUE);
		}

		else if (currentLevel == maxExpLevel)
			result = new Node(null, heuristic.heuristic(currentNode.getState()));

		else {
			LinkedList<Node> successorList = getSuccessorList(currentNode);

			for (Node successor : successorList) {
				Node newNode = alphaBeta(successor, currentLevel + 1, alpha, beta);

				if (isMax(currentLevel)) {
					if (newNode.getHeuristic() >= alpha) {
						alpha = newNode.getHeuristic();
						result = new Node(successor.getState(), newNode.getHeuristic());
					}
					else if (newNode.getHeuristic() <= beta) {
						beta = newNode.getHeuristic();
						result = new Node(successor.getState(), newNode.getHeuristic());
					}
				}

				if (isMax(currentLevel))
					result = new Node(result.getState(), alpha);
				else result = new Node(result.getState(), beta);
			}
		}

		return result;
	}


	// Return true if currentLevel is a pair number.
	private boolean isMax(int currentLevel) {
		return currentLevel % 2 == 0;
	}

	public LinkedList<Node> getSuccessorList(Node node) {

		LinkedList<State> successorStates = node.getState().getSuccessorList();
		LinkedList<Node> successorNodes = new LinkedList<>();

		for (State state : successorStates)
			successorNodes.add(new Node(state, heuristic.heuristic(state)));

		return successorNodes;
	}
}
