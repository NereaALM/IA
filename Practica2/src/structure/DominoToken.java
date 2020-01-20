package structure;

public class DominoToken {

	public int left;
	public int right;

	public DominoToken(int left, int right) {
		this.left = left;
		this.right = right;
	}

	public DominoToken clone() {
		return new DominoToken(left, right);
	}

	public boolean isEqual(DominoToken token) {
		return left == token.left && right == token.right ||
				left == token.right && right == token.left;
	}

	public String toString() {
		return left + "\t" + right;
	}
}
