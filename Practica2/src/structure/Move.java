package structure;

public class Move {
	public DominoToken usedToken;
	public boolean isLeftMine;
	public boolean isLeftBoard;

	public Move(DominoToken usedToken, boolean isLeftMine, boolean isLeftBoard) {
		this.usedToken = usedToken;
		this.isLeftBoard = isLeftBoard;
		this.isLeftMine = isLeftMine;
	}
}
