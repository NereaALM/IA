import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

    public static void main( String[] args ) {

        final int mapSize = 10;
        State[][] map = new State[ mapSize ][ mapSize ];

        int initPosX = 0;
        int initPosY = 0;
        int finalPosX = map.length - 1;
        int finalPosY = map.length - 1;

        State initState;
        State finalState;

        Node initNode;
        Node finalNode;

        SearchingAlgorithm bestFirst = new BestFirst();
        SearchingAlgorithm aStar = new AStar();

        String fileDir;
        FileReader fileReader;
        BufferedReader bufferedReader;
        Scanner scanner;
        String[] line;


        System.out.println( "Mi primera práctica de IA! ^^" );

        try {

            fileDir = "Map.txt";
            fileReader = new FileReader( fileDir );
            bufferedReader = new BufferedReader( fileReader );
            scanner = new Scanner( bufferedReader );

            // Reading of the map from a file:

            while ( scanner.hasNextLine() ) {

                for( int r = 0; r < mapSize; r++ ) {

                    line = scanner.nextLine().trim().split( " " );
                    for( int c = 0; c < mapSize; c++ ) {

                        State auxState = new State( r, c,  Integer.parseInt( line[ c ] ) );
                        map[ r ][ c ] = auxState;

                        System.out.print( auxState.getRoadType() );
                    }
                    System.out.println();
                }
            }

            // Testing of the search algorithm:

            initState = map[ initPosX ][ initPosY ];
            finalState = map[ finalPosX ][ finalPosY ];

            // bestFirst.Search( initState, finalState );
            // aStar.Search( initState, finalState );

        }
        catch ( FileNotFoundException e ) {
            e.printStackTrace();
        }
    }
}
