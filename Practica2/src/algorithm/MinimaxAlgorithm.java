package algorithm;

import heuristic.Heuristic;
import structure.State;

import java.util.LinkedList;

public class MinimaxAlgorithm {

    private Heuristic heuristic;
    private int maxExpLevel;

    public MinimaxAlgorithm( int maxExpLevel, Heuristic heuristic ) {
        this.maxExpLevel = maxExpLevel;
        this.heuristic = heuristic;
    }


    public Node minimax( Node currentNode, int currentLevel ) {

        Node result;

        if( currentNode.getState().isFinal() != 0 ) {

            if ( currentNode.getState().isWinner() )
                result = new Node( null, Float.MAX_VALUE );
            else result = new Node( null, -Float.MAX_VALUE );
        }
        else if( currentLevel == maxExpLevel )
            result = new Node( null, heuristic.heuristic( currentNode.getState() ) );

        else {

            if( isMax( currentLevel ) )
                result = new Node( null, -Float.MAX_VALUE );
            else result = new Node( null, Float.MAX_VALUE );

            LinkedList< Node > successorList = getSuccessorList( currentNode );
            for( Node successor : successorList ) {

                Node newNode = minimax( successor, currentLevel + 1 );
                if( isMax( currentLevel ) ) {

                    if ( newNode.getHeuristic() > result.getHeuristic() )
                        result = new Node( successor.getState().clone(), newNode.getHeuristic() );

                    else if ( newNode.getHeuristic() < result.getHeuristic() )
                        result = new Node( successor.getState().clone(), newNode.getHeuristic() );
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

