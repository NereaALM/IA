import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;


public class Main
{
    public static void main( String[] args )
    {
        final int mapSize = 10;
        int[][] map;
        State iniState;
        State finalState;

        String fileDir;
        FileReader fileReader;
        BufferedReader bufferedReader;
        Scanner scanner;
        String[] line;


        map = new int[ mapSize ][ mapSize ];

        try
        {
            fileDir = "Map.txt";
            fileReader = new FileReader( fileDir );
            bufferedReader = new BufferedReader( fileReader );
            scanner = new Scanner( bufferedReader );

            while ( scanner.hasNextLine() )
            {
                for( int r = 0; r < mapSize; r++ )
                {
                    line = scanner.nextLine().trim().split( " " );
                    for( int c = 0; c < mapSize; c++ )
                    {
                        map[r][c] = Integer.parseInt( line[c] );
                        System.out.print( map[r][c] );
                    }
                    System.out.println();
                }
            }
        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }

        System.out.println( "Mi primera práctica de IA! ^^" );
    }
}
