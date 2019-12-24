package structure;

public class DominoToken implements Cloneable {

    private int left;
    private int right;

    public DominoToken(int left, int right ) {
        this.left = left;
        this.right = right;
    }


    public DominoToken clone() {
        return new DominoToken( left, right );
    }

    public DominoToken reverse() {
        return new DominoToken( right, left );
    }

    public boolean isEqual( DominoToken token ) {
        return left == token.left && right == token.right ||
                left == token.right && right == token.left;
    }

    public String toString() {
        return left + "\t" + right;
    }


    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
}
