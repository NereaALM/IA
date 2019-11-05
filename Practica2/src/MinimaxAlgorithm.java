public class MinimaxAlgorithm {

    private int maxLevel;
    private Heuristic heuristic;

    public MinimaxAlgorithm(){

        maxLevel = 0;
        heuristic = new Heuristic();
    }

    public Node minimax( Node currentNode, int currentLevel ) {

        Node node;

        if( isFinal( currentNode ) )
            node = new Node( Integer.MAX_VALUE );

        else if ( currentLevel == maxLevel )
            node = new Node( heuristic(  ) );



        return node;
    }

    private boolean isFinal(Node currentNode) {
        return false;
    }
}
