package structure;

import java.util.LinkedList;
import java.util.Random;

public class State {

    private DominoToken board;
    private LinkedList< DominoToken > myTokens;
    private LinkedList< DominoToken > opponentTokens;

    public State( DominoToken board,
                  LinkedList< DominoToken > myTokens,
                  LinkedList< DominoToken > player2 ) {

        this.board = board;
        this.myTokens = myTokens;
        this.opponentTokens = player2;
    }


    // Initialization for the beginning of the game.
    // The board is null and the tokens are distributed randomly.
    public State() {
        board = null;
        distributeTokens();
    }

    // This method fill the lists of the players randomly.
    public void distributeTokens() {

        myTokens = new LinkedList<>();
        opponentTokens = new LinkedList<>();

        Random random = new Random();
        LinkedList< DominoToken > tokenList = createTokens();
        for( DominoToken token : tokenList ) {

            if( myTokens.size() == 14 )
                opponentTokens.add( token );

            else if( opponentTokens.size() == 14 )
                myTokens.add( token );

            else if( random.nextInt() % 2 == 0 )
                myTokens.add( token );

            else opponentTokens.add( token );
        }
    }

    // This method creates a list with the tokens of the game.
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


    // This method returns 0 if the state is not final
    // 1 if is final because one player has no tokens
    // 2 if both players have tokens but these don't fit on the board.
    public int isFinal() {

        int finalState = 0;

        if( myTokens.isEmpty() || opponentTokens.isEmpty() )
            finalState = 1;

        else if ( getPossibleTokens( myTokens ).isEmpty() && getPossibleTokens( opponentTokens ).isEmpty() )
            finalState = 2;

        return finalState;
    }

    // Returns true if the player1 is the winner.
    public boolean isWinner( ) {
        boolean isWinner = false;

        if (    myTokens.isEmpty() ||
                isFinal() == 2 && ( count( myTokens ) < count( opponentTokens ) ) )
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

    // This method returns a list with all the tokens that can be used on the board.
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

    public LinkedList< State > getSuccessorList() {
        LinkedList< State > successorList = new LinkedList<>();
        LinkedList< DominoToken > possibleTokens = getPossibleTokens( myTokens );

        State newState;
        for( DominoToken token : possibleTokens ) {
            newState = new State( board, myTokens, opponentTokens );
            newState.myTokens.remove( token );

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


    public DominoToken getBoard() {
        return board;
    }

    public LinkedList< DominoToken > getMyTokens() {
        return myTokens;
    }

    public LinkedList< DominoToken > getOpponentTokens() {
        return opponentTokens;
    }
}