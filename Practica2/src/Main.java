import structure.State;

import java.util.Scanner;

public class Main {
    public static void main( String[] args ) {

        Scanner scanner = new Scanner( System.in );
        System.out.println(
                "Select an option: \n" +
                "\t 1. Machine vs Machine \n" +
                "\t 2. Machine vs Person");
        int gameType = scanner.nextInt();

        System.out.println(
                "Select which heuristic function do you prefer: \n" +
                "\t 1. Heuristic 1 \n" +
                "\t 2. Heuristic 2 \n" +
                "\t 3. Heuristic 3");
        int heuristicNum = scanner.nextInt();
    }
}
