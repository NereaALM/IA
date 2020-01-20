import algorithm.*;
import heuristic.*;
import structure.*;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static int maxExpLevel = 3;

	public static void main(String[] args) {

		System.out.println(
				"Select an option: \n" +
						"\t 1. Machine vs Machine \n" +
						"\t 2. Machine vs Person");
		int gameType = scanner.nextInt();

		switch (gameType) {

			case 1:
				gameMachineVsMachine();
				break;

			case 2:
				gameMachineVsPerson();
				break;

			default:
				System.out.println("Invalid option");
				break;
		}
		scanner.close();
	}

	private static void gameMachineVsMachine() {

		State state = new State();
		Node node;

		Heuristic player1H = heuristicSelector();
		GameAlgorithm player1 = algorithmSelector(player1H, true);

		Heuristic player2H = heuristicSelector();
		GameAlgorithm player2 = algorithmSelector(player2H, false);

		while (state.whichFinal() == 0) {

			System.out.println(state.toString());

			if (state.isPlayer1Turn())
				node = player1.gameAlgorithm(new Node(state, player1H.heuristic(state)), 0);

			else node = player2.gameAlgorithm(new Node(state, player2H.heuristic(state)), 0);

			state = node.getState();
		}

		if (state.isWinner()) System.out.println("The player 1 is the winner");
		else System.out.println("The player 2 is the winner");
	}

	private static void gameMachineVsPerson() {

		Heuristic heuristic = heuristicSelector();
		algorithmSelector(heuristic, true);

		// Human TO DO
	}

	// TO DO: think in how to do this.
	private static GameAlgorithm algorithmSelector(Heuristic heuristic, boolean isPlayer1) {

		GameAlgorithm gameAlgorithm;

		System.out.println(
				"Select which algorithm do you prefer: \n" +
						"\t 1. Minimax \n" +
						"\t 2. Alpha-beta");
		int option = scanner.nextInt();

		switch (option) {

			case 1:
				gameAlgorithm = new Minmax(maxExpLevel, heuristic, isPlayer1);
				break;

			case 2:
				gameAlgorithm = new AlphaBeta(maxExpLevel, heuristic, isPlayer1);
				break;

			default:
				gameAlgorithm = null;
				System.out.println("Invalid option");
				break;
		}

		return gameAlgorithm;
	}

	private static Heuristic heuristicSelector() {

		Heuristic heuristic;

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Select which heuristic function do you prefer: \n" +
						"\t 1. Heuristic 1 \n" +
						"\t 2. Heuristic 2 \n" +
						"\t 3. Heuristic 3");
		int option = scanner.nextInt();

		switch (option) {

			case 1:
				heuristic = new TheGood();
				break;

			case 2:
				heuristic = new TheBad();
				break;

			case 3:
				heuristic = new TheUgly();
				break;

			default:
				heuristic = null;
				System.out.println("Invalid option");
				break;
		}

		return heuristic;
	}
}