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
        Node node = null;
        boolean isPlayer1Turn = state.isPlayer1Turn();

        Heuristic player1H = heuristicSelector();
        GameAlgorithm player1 = algorithmSelector(player1H, true);

        Heuristic player2H = heuristicSelector();
        GameAlgorithm player2 = algorithmSelector(player2H, false);

        while (state != null && state.whichFinal() == 0) {

            System.out.println(state.toString() + "\n");

            if (state.isPlayer1Turn())
                node = player1.gameAlgorithm(new Node(state, player1H.heuristic(state)), 0);

            else node = player2.gameAlgorithm(new Node(state, player2H.heuristic(state)), 0);

            state = node.getState();

            isPlayer1Turn = !isPlayer1Turn;
        }

        if (!isPlayer1Turn) {
            if (node.getHeuristic() == Float.MAX_VALUE) System.out.println("The player 1 is the winner");
            else System.out.println("The player 2 is the winner");
        } else {
            if (node.getHeuristic() == Float.MAX_VALUE) System.out.println("The player 2 is the winner");
            else System.out.println("The player 1 is the winner");
        }

        if (state.whichFinal() == 1) System.out.println("The winner has no tokens");
        else System.out.println("Anybody has a possible move");
    }

    private static void gameMachineVsPerson() {

        State state = new State();
        Node node = null;
        boolean isPlayer1Turn = state.isPlayer1Turn();

        Heuristic player1H = heuristicSelector();
        GameAlgorithm player1 = algorithmSelector(player1H, true);

        while (state != null && state.whichFinal() == 0) {

            System.out.println(state.toString() + "\n");

            if (state.isPlayer1Turn()) {
                node = player1.gameAlgorithm(new Node(state, player1H.heuristic(state)), 0);
                state = node.getState();
            }
            else {
                System.out.println("Choose your movement: \n");
                System.out.println(state.getPossibleMoves(state.getPlayer2()));
                int move = scanner.nextInt();
                state = state.getSuccessor(state.getPossibleMoves(state.getPlayer2()).get(move));
            }
            isPlayer1Turn = !isPlayer1Turn;
        }

        if (!isPlayer1Turn) {
            if (state.isWinner()) System.out.println("The player 1 is the winner");
            else System.out.println("The player 2 is the winner");
        } else {
            if (node.getHeuristic() == Float.MAX_VALUE) System.out.println("The player 2 is the winner");
            else System.out.println("The player 1 is the winner");
        }

        if (state.whichFinal() == 1) System.out.println("The winner has no tokens");
        else System.out.println("Anybody has a possible move");
    }

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

        System.out.println(
                "Select which heuristic function do you prefer: \n" +
                        "\t 1. The good \n" +
                        "\t 2. The bad \n" +
                        "\t 3. The ugly");
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