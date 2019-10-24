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
        SearchingAlgorithm searchingAlgorithm;
        List< Node > way = new ArrayList<>();


        System.out.println( "Mi primera práctica de IA! ^^" );

        try {

            readFile(mapWidth, map);

            int initPosX = 0;
            int initPosY = 0;
            int finalPosX = mapWidth - 1;
            int finalPosY = mapWidth - 1;

            State initState = map.get( initPosY * mapWidth + initPosX );
            State finalState = map.get( finalPosY * mapWidth + finalPosX );

            searchingAlgorithm = new BestFirst();
            way = searchingAlgorithm.Search( initState, finalState );
            int bfCost = searchingAlgorithm.getWayCost( way );
            System.out.println( "Total cost of Best First :\t" + bfCost );

            searchingAlgorithm = new AStar();
            way = searchingAlgorithm.Search( initState, finalState );
            int aStarCost = searchingAlgorithm.getWayCost( way );
            System.out.println( "Total cost of A* :\t" + aStarCost );
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

        State upState;
        State leftState;

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

    private static void fillSuccessorList(int mapWidth, HashMap<Integer, State> map, State currentState) {

        int r = currentState.getRow();
        int c = currentState.getColumn();

        State upState;
        State leftState;

        upState = map.get( ( r - 1 ) * mapWidth + c );


        // Up
        if ( upState != null && upState.getRoadType() != 0 )
        {
            currentState.addSuccessor( map.get( ( r - 1 ) * mapWidth + c ) );

            // Down ( If it is successor, the current state has to be a successor for it too )
            if ( ! upState.getSuccessorList().contains( currentState ) )
                upState.addSuccessor( currentState );
        }

        // Left
        leftState = map.get( r * mapWidth + ( c - 1 ) );
        if ( leftState != null && leftState.getRoadType() != 0 )
        {
            currentState.addSuccessor( map.get( ( r - 1 ) * mapWidth + c ) );

            // Right
            if ( leftState.getSuccessorList().contains( currentState ) )
                leftState.addSuccessor( currentState );
        }
    }
}
