package algorithm;

import heuristic.Heuristic;

public class MinimaxAlgorithm {

    private Heuristic heuristic;
    private int maxExpLevel;

/*
    public MinimaxAlgorithm( int maxExpLevel, heuristic ) {
        this.maxExpLevel = maxExpLevel;
        heuristic = new Heu
    }

    public Node minimax( Node currentNode, int currentLevel ) {

        Node result;

        // Direct cases:
        if( isFinal( currentNode ) ) {

            if( isWinner( currentNode, currentLevel ) )
                result = new Node( Integer.MAX_VALUE );

            else result = new Node( Integer.MIN_VALUE );
        }
        else if( currentLevel == maxExpLevel )
            result = new Node( heuristic.heuristic() );

        // Recursive case:
        else {

            if( isMax( currentLevel ) )
                result = new Node( Integer.MIN_VALUE );

            else result = new Node( Integer.MAX_VALUE );

            while( successorsExist( currentNode ) ) {

                Node successor = followingSuccessor( currentNode );
                Node newNode = minimax( successor, currentLevel + 1 );

                if( isMax( currentLevel ) ) {

                    if ( newNode.getHeuristic() > result.getHeuristic() ) {

                        result.setHeuristic( newNode.getHeuristic() );
                        result.setState( successor.getState() );
                    }
                }
                else {

                    if( newNode.getHeuristic() < result.getHeuristic() ) {

                        result.setHeuristic( newNode.getHeuristic() );
                        result.setState( successor.getState() );
                    }
                }
            }
        }

        return result;
    }

    // TO DO:
    private boolean isWinner( Node currentNode, int currentLevel ) {
        return true;
    }

    private Node followingSuccessor( Node currentNode ) {
        return null;
    }

    private boolean successorsExist( Node currentNode ) {
        return true;
    }

    private boolean isMax( int currentLevel ) {
        return true;
    }

    private boolean isFinal( Node currentNode ) {
        return true;
    }

 */
}
