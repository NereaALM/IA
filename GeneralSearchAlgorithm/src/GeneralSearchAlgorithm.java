import java.util.LinkedList;
import java.util.List;

public class GeneralSearchAlgorithm
{
    // Assistant methods.

    // TO DO: This method takes a node from a list and
    // returns it.
    public State selectNode(List< State > slopes )
    {
        State node;
        int pos = 0;

        node = slopes.get( pos );
        return node;
    }

    public boolean generalSearchAlgorithm( State initState, State finalState )
    {
        boolean found;

        List < State > slopes = new LinkedList<>();
        List < State > treated = new LinkedList<>();
        State node;


        slopes.add( initState );
        found = false;

        while( ( !found ) && ( !slopes.isEmpty() ) )
        {
            node = selectNode( slopes );

            if ( node == finalState )
            {
                found = true;
            }
            else
            {
                // TO DO: Recorrer succesors del node afegint un nivell mes a la llista de pendensts ( slopes ).
            }
        }

        return found;
    }


    public static void main (String [ ] args)
    {

    }
}
