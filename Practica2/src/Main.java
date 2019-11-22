import structure.DominoToken;
import structure.State;


import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {
         State state = new State();

         LinkedList< DominoToken > list = state.createTokens();

         System.out.println(list.toString());

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
                System.out.println("Machine vs Machine");

                // Machine 1
                System.out.println("Machine 1:");
                algorithmSelector();
                heuristicSelector();

                System.out.println();

                // Machine 2
                System.out.println("Machine 2:");
                algorithmSelector();
                heuristicSelector();

                break;

            // 2. Machine vs Person
            case 2:
                System.out.println("Machine vs Person");

                algorithmSelector();
                heuristicSelector();

                break;

            default:
                System.out.println("Invalid option");
                break;
        }
    }

    private static void algorithmSelector() {

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select which algorithm do you prefer: \n" +
                        "\t 1. Minimax \n" +
                        "\t 2. Alpha-beta" );
        int option = scanner.nextInt();

        switch ( option ) {

            // Minimax:
            case 1:
                System.out.println( "Minimax" );
                break;

            // AlphaBeta
            case 2:
                System.out.println( "Alpha-beta" );
                break;

            default:
                System.out.println( "Invalid option" );
                break;
        }
    }

    private static void heuristicSelector() {

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
                System.out.println( "Heuristic 1" );
                break;

            // Heuristic 2
            case 2:
                System.out.println( "Heuristic 2" );
                break;

            // Heuristic 3
            case 3:
                System.out.println( "Heuristic 3" );
                break;

            default:
                System.out.println( "Invalid option" );
                break;
        }
    }
}