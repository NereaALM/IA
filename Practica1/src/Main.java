import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main( String[] args )
    {
        final int size = 10;
        int[][] map = new int[size][size];

        String fileDir;
        FileReader fileReader;
        BufferedReader bufferedReader;
        Scanner scanner;
        String[] line;

        // LLegir mapa de fitxer.
        try
        {
            fileDir = "Map.txt";
            fileReader = new FileReader( fileDir );
            bufferedReader = new BufferedReader( fileReader );
            scanner = new Scanner( bufferedReader );

            while ( scanner.hasNextLine() )
            {
                for( int r = 0; r < size; r++ )
                {
                    line = scanner.nextLine().trim().split( " " );
                    for( int c = 0; c < size; c++ )
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


        // Llegir estat inicial i estat final.
        // Escollir A* o BF.
        // Fer cerca.
        // Mostrar resultats.
        System.out.println( "Mi primera práctica de IA! ^^" );
    }
}
