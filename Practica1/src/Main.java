import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    // _____________________________TO DO_________________________________
    // Accumulator of cost in A*.
    // pendingList methods well done.
    //____________________________________________________________________

    public static void main( String[] args ) {

        final int mapWidth = 10;
        HashMap< Integer, State > map = new HashMap<>();
        List< Node > way;
        SearchingAlgorithm searchingAlgorithm;


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
            searchingAlgorithm = new BestFirst();
            way = searchingAlgorithm.Search( initState, finalState );

            if ( way == null )
                System.out.println( "Final state not found" );
            else {

                int bfCost = searchingAlgorithm.getWayCost( way );
                System.out.println( "Total cost of Best First :\t" + bfCost );
            }


            // A* :
            searchingAlgorithm = new AStar();
            way = searchingAlgorithm.Search( initState, finalState );

            if ( way == null )
                System.out.println( "Final state not found" );
            else {

                int aStarCost = searchingAlgorithm.getWayCost( way );
                System.out.println( "Total cost of A* :\t" + aStarCost );
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
    }

    private static void fillSuccessorList( int mapWidth, HashMap<Integer, State> map, State currentState ) {

        int r = currentState.getRow();
        int c = currentState.getColumn();

        // Up
        State upState = map.get( ( r - 1 ) * mapWidth + c );

        if ( upState != null && upState.getRoadType() != 0 )
        {
            currentState.addSuccessor( upState );

            // Down ( If it is successor, the current state has to be a successor for it too )
            if ( ! upState.getSuccessorList().contains( currentState ) )
                upState.addSuccessor( currentState );
        }

        // Left
        State leftState = map.get( r * mapWidth + ( c - 1 ) );

        if ( leftState != null && leftState.getRoadType() != 0 )
        {
            currentState.addSuccessor( leftState );

            // Right
            if ( leftState.getSuccessorList().contains( currentState ) )
                leftState.addSuccessor( currentState );
        }
    }
}
