package structure;

import java.util.LinkedList;
import java.util.Random;

public class State implements Cloneable {

    private DominoToken board;
    private LinkedList< DominoToken > player1;
    private LinkedList< DominoToken > player2;

    public State( DominoToken board,
                  LinkedList< DominoToken > player1,
                  LinkedList< DominoToken > player2 ) {

        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    // Initialization for the beginning of the game.
    // The board is null and the tokens are distributed randomly.
    public State() {
        board = null;
        distributeTokens();
    }

    // This method fill the lists of the players randomly.
    public void distributeTokens() {

        player1 = new LinkedList<>();
        player2 = new LinkedList<>();

        Random random = new Random();
        LinkedList< DominoToken > tokenList = createTokens();
        for( DominoToken token : tokenList ) {

            if( player1.size() == 14 )
                player2.add( token.clone() );

            else if( player2.size() == 14 )
                player1.add( token.clone() );

            else if( random.nextInt() % 2 == 0 )
                player1.add( token.clone() );

            else player2.add( token.clone() );
        }
    }

    // This method creates a list with the tokens of the game.
    public LinkedList< DominoToken > createTokens() {

        LinkedList< DominoToken > tokenList = new LinkedList<>();
        int right;
        int accum = 0;

        for( int left = 0; left <= 6; left++ ) {
            right = accum;
            while( right <= 6 ) {
                tokenList.add( new DominoToken( left, right ) );
                right++;
            }
            accum++;
        }

        return tokenList;
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

    // TO DO: Change for being able for both lists.
    // Returns true if the player1 is the winner.
    public boolean isWinner() {

        boolean isWinner = false;

        if (    player1.isEmpty() ||
                isFinal() == 2 && ( count( player1 ) < count( player2 ) ) )
            isWinner = true;

        return isWinner;
    }

    // This method counts the number of points of a list of tokens.
    public int count( LinkedList < DominoToken > tokenList ) {
        int num = 0;

        for( DominoToken token : tokenList ) {
            num += token.getLeft();
            num += token.getRight();
        }

        return num;
    }

    // TO DO: Change for being able for both lists.
    public LinkedList< State > getSuccessorList() {

        LinkedList< State > successorList = new LinkedList<>();
        LinkedList< DominoToken > possibleTokens = getPossibleTokens( player1 );

        State newState;
        for( DominoToken token : possibleTokens ) {
            newState = new State( board, player1, player2 );
            newState.player1.remove( token );

            if( board.getRight() == token.getRight() )
                board.setRight( token.getLeft() );
            else if( board.getRight() == token.getLeft() )
                board.setRight( token.getRight() );
            else if( board.getLeft() == token.getRight() )
                board.setLeft( token.getLeft() );
            else if( board.getLeft() == token.getLeft() )
                board.setLeft( token.getRight() );

            successorList.add( newState );
        }

        return successorList;
    }

    // This method returns a list with all the tokens that can be used on the board.
    public LinkedList< DominoToken > getPossibleTokens( LinkedList< DominoToken> playerList ) {

        LinkedList< DominoToken > possibleTokenList = new LinkedList<>();

        for( DominoToken token : playerList ) {

            if( token.getRight() == board.getRight() ||
                    token.getRight() == board.getLeft() ||
                    token.getLeft() == board.getRight() ||
                    token.getLeft() == board.getLeft() )

                possibleTokenList.add( token.clone() );
        }

        return possibleTokenList;
    }


    public State clone() {
        return new State( board, player1, player2 );
    }

    public DominoToken getBoard() {
        return board;
    }

    public LinkedList< DominoToken > getPlayer1() {
        return player1;
    }

    public LinkedList< DominoToken > getPlayer2() {
        return player2;
    }
}