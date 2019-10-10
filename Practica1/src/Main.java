import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main
{
    public static void main( String[] args )
    {
        // LLegir mapa de fitxer.
        final int size = 10;
        int[][] map = new int[size][size];

        try
        {
            String fileDir = "Map.txt";
            FileReader fileReader = new FileReader( fileDir );
            BufferedReader bufferedReader = new BufferedReader( fileReader );
            StringTokenizer st = new StringTokenizer( " " );

            String line = bufferedReader.readLine();

            while ( line != null )
            {
                System.out.println( line );
                line = bufferedReader.readLine();
            }

        }
        catch ( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( IOException e )
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
