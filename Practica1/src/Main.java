import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {

        final int mapWidth = 10;
        HashMap< Integer, State > map = new HashMap<>();


        System.out.println( "Mi primera práctica de IA! ^^" );

        try {

            // Read map from file.
            readFile( mapWidth, map );

            // Initialize searching algorithm input arguments.
            int initPosX = 0;
            int initPosY = 0;
            int finalPosX = mapWidth - 1;
            int finalPosY = mapWidth - 1;

            State initState = map.get( initPosY * mapWidth + initPosX );
            State finalState = map.get( finalPosY * mapWidth + finalPosX );


            // Best First :
            List< NodeBestFirst > wayBF;
            BestFirst bestFirst = new BestFirst();
            wayBF = bestFirst.Search( initState, finalState );

            if ( wayBF == null )
                System.out.println( "Final state not found" );
            else {

                int bfCost = bestFirst.getWayCost( wayBF );
                System.out.println( "Total cost of Best First :\t" + bfCost );
                System.out.println();

                for ( NodeBestFirst node : wayBF )
                    System.out.println( node.getState() );
                System.out.println();
            }


            // A* :
            List< NodeAStar > wayAStar;
            AStar aStar = new AStar();
            wayAStar = aStar.Search( initState, finalState );

            if ( wayAStar == null )
                System.out.println( "Final state not found" );
            else {

                int aStarCost = aStar.getWayCost( wayAStar );
                System.out.println( "Total cost of A* :\t" + aStarCost );
                System.out.println();

                for ( NodeAStar node : wayAStar )
                    System.out.println( node.getState() );
                System.out.println();
            }
        }
        catch ( FileNotFoundException e ) {

            e.printStackTrace();
        }
    }


    private static void readFile( int mapWidth, HashMap<Integer, State> map ) throws FileNotFoundException {

        String fileDir = "Map.txt";
        FileReader fileReader = new FileReader( fileDir );;
        BufferedReader bufferedReader = new BufferedReader( fileReader );
        Scanner scanner = new Scanner( bufferedReader );
        String[] line;

        while ( scanner.hasNextLine() ) {

            for( int r = 0; r < mapWidth; r++ ) {

                line = scanner.nextLine().trim().split( " " );
                for( int c = 0; c < mapWidth; c++ ) {

                    State currentState = new State( r, c,  Integer.parseInt( line[ c ] ) );
                    fillSuccessorList(mapWidth, map, currentState);
                    map.put( r * mapWidth + c, currentState );

                    System.out.print( currentState.getRoadType() );
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    private static void fillSuccessorList( int mapWidth, HashMap<Integer, State> map, State currentState ) {

        int r = currentState.getRow();
        int c = currentState.getColumn();

        // Up
        if( r != 0 ) {

            State upState = map.get((r - 1) * mapWidth + c);

            if (upState != null && upState.getRoadType() != 0) {
                currentState.addSuccessor(upState);

                // Down ( If it is successor, the current state has to be a successor for it too )
                upState.addSuccessor(currentState);
            }
        }

        // Left
        if( c != 0 ) {

            State leftState = map.get(r * mapWidth + (c - 1));

            if (leftState != null && leftState.getRoadType() != 0) {
                currentState.addSuccessor(leftState);

                // Right
                leftState.addSuccessor(currentState);
            }
        }
    }
}
