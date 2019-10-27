public class Heuristic {

    public Heuristic() {}

    // TO DO:

    // Heuristic 1.
    public int distance( State currentState, State finalState ) {

        int heuristic;

        int incrementX;
        int incrementY;

        int iniX = currentState.getColumn();
        int iniY = currentState.getRow();
        int finalX = finalState.getColumn();
        int finalY = finalState.getRow();


        incrementX = finalX - iniX;
        if( incrementX < 0 ) incrementX = - incrementX;

        incrementY = finalY - iniY;
        if( incrementY < 0 ) incrementY = - incrementY;


        // There are no diagonals so the increment will be exclusive for an axis.
        if ( incrementX > 0 )
            heuristic = incrementX;

        else heuristic = incrementY;


        return heuristic;
    }

    // Heuristic 2.
    public int roadType( State state ) {

        int heuristic = state.getRoadType();

        return heuristic;
    }

    // Heuristic 3.
    public int distanceRoadType( State currentState, State finalState ) {

        int heuristic;

        int distance = distance( currentState, finalState );
        int roadType = roadType( currentState );

        heuristic = distance + roadType;

        return heuristic;
    }
}
