import algorithm.*;
import heuristic.*;
import structure.*;
import java.util.Scanner;

public class Main {

    private static int maxExpLevel = 3;

    public static void main( String[] args ) {

        State state = new State();
        gameModeSelector();
    }

    private static void gameModeSelector() {

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select an option: \n" +
                        "\t 1. Machine vs Machine \n" +
                        "\t 2. Machine vs Person");
        int gameType = scanner.nextInt();

        switch ( gameType ) {

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
    }

    private static void gameMachineVsMachine() {

        Heuristic heuristicMac1 = heuristicSelector();
        algorithmSelector( heuristicMac1 );

        Heuristic heuristicMac2 = heuristicSelector();
        algorithmSelector( heuristicMac2 );
    }

    private static void gameMachineVsPerson() {

        Heuristic heuristic = heuristicSelector();
        algorithmSelector( heuristic );
    }

    // TO DO: think in how to do this.
    private static void algorithmSelector( Heuristic heuristic ) {

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select which algorithm do you prefer: \n" +
                        "\t 1. Minimax \n" +
                        "\t 2. Alpha-beta" );
        int option = scanner.nextInt();

        switch ( option ) {

            case 1:
                MinimaxAlgorithm minimaxAlgorithm = new MinimaxAlgorithm( maxExpLevel, heuristic );
                break;

            case 2:
                AlphaBetaAlgorithm alphaBetaAlgorithm = new AlphaBetaAlgorithm( maxExpLevel, heuristic );
                break;

            default:
                System.out.println( "Invalid option" );
                break;
        }
    }

    private static Heuristic heuristicSelector() {

        Heuristic heuristic;

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select which heuristic function do you prefer: \n" +
                        "\t 1. Heuristic 1 \n" +
                        "\t 2. Heuristic 2 \n" +
                        "\t 3. Heuristic 3");
        int option = scanner.nextInt();

        switch ( option ) {

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
                System.out.println( "Invalid option" );
                break;
        }

        return heuristic;
    }
}