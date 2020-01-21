package algorithm;

import heuristic.Heuristic;
import structure.State;

import java.util.LinkedList;

public class Minmax implements GameAlgorithm {

	private Heuristic heuristic;
	private int maxExpLevel;
	private boolean isPlayer1;

	public Minmax(int maxExpLevel, Heuristic heuristic, boolean isPlayer1) {
		this.maxExpLevel = maxExpLevel;
		this.heuristic = heuristic;
		this.isPlayer1 = isPlayer1;
	}

	@Override
	public Node gameAlgorithm(Node currentNode, int currentLevel) {

		Node result;

		if (currentNode.getState().whichFinal() != 0) {
			if (currentNode.getState().isWinner() == isPlayer1)
				result = new Node(null, Float.MAX_VALUE);
			else result = new Node(null, -Float.MAX_VALUE);
		} else if (currentLevel == maxExpLevel)
			result = new Node(null, heuristic.heuristic(currentNode.getState()));

		else {
			if (isMax(currentLevel))
				result = new Node(null, -Float.MAX_VALUE);
			else result = new Node(null, Float.MAX_VALUE);

			LinkedList<Node> successorList = getSuccessorList(currentNode);
			for (Node successor : successorList) {
				Node newNode = gameAlgorithm(successor, currentLevel + 1);
				if (isMax(currentLevel)) {
					if (newNode.getHeuristic() >= result.getHeuristic())
						result = new Node(successor.getState(), newNode.getHeuristic());
					else if (newNode.getHeuristic() <= result.getHeuristic())
						result = new Node(successor.getState(), newNode.getHeuristic());
				}
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