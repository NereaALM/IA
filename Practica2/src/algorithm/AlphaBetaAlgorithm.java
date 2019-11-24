package algorithm;

import heuristic.Heuristic;
import structure.State;

import java.util.LinkedList;

public class AlphaBetaAlgorithm {

    private Heuristic heuristic;
    private int maxExpLevel;

    public AlphaBetaAlgorithm( int maxExpLevel, Heuristic heuristic ) {
        this.maxExpLevel = maxExpLevel;
        this.heuristic = heuristic;
    }

    public Node alphaBeta( Node currentNode, int currentLevel, int alpha, int beta ) {

        Node result;

        // Direct cases:
        if( currentNode.getState().isFinal() != 0 ) {
            if( currentNode.getState().isWinner() )
                result = new Node( currentNode.getState(), Float.MAX_VALUE );
            else result = new Node( currentNode.getState(), -Float.MAX_VALUE );
        }
        else if( currentLevel == maxExpLevel )
            result = new Node( currentNode.getState(), heuristic.heuristic( currentNode.getState() ) );

            // Recursive case:
        else {
            if( isMax( currentLevel ) )
                result = new Node( currentNode.getState(), -Float.MAX_VALUE );
            else result = new Node( currentNode.getState(), Float.MAX_VALUE );

            LinkedList< Node > successorList = getSuccessorList( currentNode );
            for( Node successor : successorList ) {

                Node newNode = alphaBeta( successor, currentLevel + 1 , alpha, beta);

                if( isMax( currentLevel ) ) {
                    if ( newNode.getHeuristic() > result.getHeuristic() )
                        result = new Node( successor.getState(), newNode.getHeuristic() );

                    else if ( newNode.getHeuristic() < result.getHeuristic() )
                        result = new Node( successor.getState(), newNode.getHeuristic() );
                }
            }
        }

        return result;
    }


    // Return true if currentLevel is a pair number.
    private boolean isMax( int currentLevel ) {
        return currentLevel % 2 == 0;
    }

    public LinkedList< Node > getSuccessorList( Node node ) {

        LinkedList< State > successorStates = node.getState().getSuccessorList();

        LinkedList< Node > successorNodes = new LinkedList<>();
        for( State state : successorStates )
            successorNodes.add( new Node( state, heuristic.heuristic( state ) ) );

        return successorNodes;
    }
}
