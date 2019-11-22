package structure;

import java.util.LinkedList;
import java.util.Random;

public class State {

    private DominoToken board;
    private LinkedList< DominoToken > player1;
    private LinkedList< DominoToken > player2;

    // Initialization for the beginning of the game.
    public State() {
        board = null;
        distributeTokens();
    }

    public State( DominoToken board,
                  LinkedList< DominoToken > player1,
                  LinkedList< DominoToken > player2 ) {

        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }


    public LinkedList< DominoToken > createTokens() {

        LinkedList< DominoToken > tokenList = new LinkedList<>();

        int accum = 0;
        for( int left = 0; left <= 6; left++ ) {
            int right = 0 + accum;
            while( right <= 6 ) {
                tokenList.add( new DominoToken( left, right ) );
                right++;
            }
            accum++;
        }

        return tokenList;
    }

    public void distributeTokens() {

        player1 = new LinkedList<>();
        player2 = new LinkedList<>();

        Random random = new Random();
        LinkedList< DominoToken > tokenList = createTokens();
        for( DominoToken token : tokenList ) {

            if( player1.size() == 14 )
                player2.add( token );

            else if( player2.size() == 14 )
                player1.add( token );

            else if( random.nextInt() % 2 == 0 )
                player1.add( token );

            else player2.add( token );
        }
    }

    // This method returns 0 if the state is not final
    // 1 if is final because one player has no tokens
    // 2 if both players have tokens but these don't fit on the board.
    public int isFinal() {

        int finalState = 0;

        if( player1.isEmpty() || player2.isEmpty() )
            finalState = 1;

        else if ( getPossibleTokens( player1 ).isEmpty() && getPossibleTokens( player2 ).isEmpty() )
            finalState = 2;

        return finalState;
    }

    public LinkedList< DominoToken > getPossibleTokens( LinkedList< DominoToken> playerList ) {
        LinkedList< DominoToken > possibleTokenList = new LinkedList<>();

        for( DominoToken token : playerList ) {

            if( token.getRight() == board.getRight() ||
            token.getRight() == board.getLeft() ||
            token.getLeft() == board.getRight() ||
            token.getLeft() == board.getLeft() )

                possibleTokenList.add( token );
        }

        return possibleTokenList;
    }

    public boolean isWinner() {
        boolean isWinner = false;
        return false;
    }

    public DominoToken getBoard() {
        return board;
    }

    public void setBoard( DominoToken board ) {
        this.board = board;
    }

    public LinkedList< DominoToken > getPlayer1() {
        return player1;
    }

    public void setPlayer1( LinkedList< DominoToken > player1 ) {
        this.player1 = player1;
    }

    public LinkedList< DominoToken > getPlayer2() {
        return player2;
    }

    public void setPlayer2( LinkedList< DominoToken > player2 ) {
        this.player2 = player2;
    }
}
