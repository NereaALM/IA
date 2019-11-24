import algorithm.*;
import heuristic.*;
import structure.*;
import java.util.Scanner;

public class Main {

    private static int maxExpLevel = 3;

    private static Heuristic heuristicMac1;
    private static Heuristic heuristicMac2;

    public static void main( String[] args ) {
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

            // 1. Machine vs Machine
            case 1:
                gameMachineVsMachine();
                break;

            // 2. Machine vs Person
            case 2:
                gameMachineVsPerson();
                break;

            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private static void algorithmSelector( Heuristic heuristic) {

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select which algorithm do you prefer: \n" +
                        "\t 1. Minimax \n" +
                        "\t 2. Alpha-beta" );
        int option = scanner.nextInt();

        switch ( option ) {

            // Minimax:
            case 1:
                MinimaxAlgorithm minimaxAlgorithm = new MinimaxAlgorithm( maxExpLevel, heuristic );
                break;

            // AlphaBeta
            case 2:
                break;

            default:
                System.out.println( "Invalid option" );
                break;
        }
    }

    private static Heuristic heuristicSelector( Heuristic heuristic ) {

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select which heuristic function do you prefer: \n" +
                        "\t 1. Heuristic 1 \n" +
                        "\t 2. Heuristic 2 \n" +
                        "\t 3. Heuristic 3");
        int option = scanner.nextInt();

        switch ( option ) {

            // Heuristic 1
            case 1:
                heuristic = new Heuristic1();
                break;

            // Heuristic 2
            case 2:
                heuristic = new Heuristic2();
                break;

            // Heuristic 3
            case 3:
                heuristic = new Heuristic3();
                break;

            default:
                System.out.println( "Invalid option" );
                break;
        }

        return heuristic;
    }

    private static void gameMachineVsMachine() {
        // Machine 1
        heuristicMac1 = heuristicSelector( heuristicMac1 );
        algorithmSelector( heuristicMac1 );
        // Machine 2
        heuristicMac2 = heuristicSelector( heuristicMac2 );
        algorithmSelector( heuristicMac2 );

        // Set initial state in which lists are filled and board is empty( null ).
        State iniState = new State();
        Node iniNode = new Node( iniState, heuristicMac1.heuristic( iniState ) );

    }

    private static void gameMachineVsPerson() {
        heuristicMac1 = heuristicSelector( heuristicMac1 );
        algorithmSelector( heuristicMac1 );

    }
}