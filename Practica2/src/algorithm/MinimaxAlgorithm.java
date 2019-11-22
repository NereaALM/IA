package algorithm;

import heuristic.Heuristic;

public class MinimaxAlgorithm {

    private Heuristic heuristic;
    private int maxExpLevel;

    public MinimaxAlgorithm( int maxExpLevel, Heuristic heuristic ) {
        this.maxExpLevel = maxExpLevel;
        this.heuristic = heuristic;
    }
/*
    public Node minimax( Node currentNode, int currentLevel ) {
        Node result;

        // Direct cases:
        if( currentNode.getState().isFinal() != 0 ) {
            if( currentNode.getState().isWinner() )
                result = new Node( currentNode.getState(), Float.MAX_VALUE );
            else result = new Node( currentNode.getState(), -Float.MAX_VALUE );
        }
        else if( currentLevel == maxExpLevel )
            result = new Node( currentNode.getState(), heuristic.heuristic() );

        // Recursive case:
        else {
            if( isMax( currentLevel ) )
                result = new Node( currentNode.getState(), -Float.MAX_VALUE );
            else result = new Node( currentNode.getState(), Float.MAX_VALUE );

            while( successorsExist( currentNode ) ) {
                Node successor = followingSuccessor( currentNode );
                Node newNode = minimax( successor, currentLevel + 1 );
                if( isMax( currentLevel ) )
                    if( newNode.getHeuristic() > result.getHeuristic() ) {
                        result = new Node( successor.getState(), newNode.getHeuristic());
                    }
                else if( newNode.getHeuristic() < result.getHeuristic() ) {
                    result = new Node( successor.getState(), newNode.getHeuristic());
                }
            }
        }

        return result;
    }

    // Return true if currentLevel is a pair number.
    private boolean isMax( int currentLevel ) {
        return currentLevel % 2 == 0;
    }*/
}
