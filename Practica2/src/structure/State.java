package structure;

import java.util.LinkedList;

public class State {

    private DominoToken board;
    private LinkedList< DominoToken > player1;
    private LinkedList< DominoToken > player2;

    // Initialization for the beginning of the game.
    public State() {

        board = null;
        // TO DO: Fill lists.
    }

    public State( DominoToken board,
                  LinkedList< DominoToken > player1,
                  LinkedList< DominoToken > player2 ) {

        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }
}
