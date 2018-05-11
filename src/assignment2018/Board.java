package assignment2018;

import assignment2018.codeprovided.Piece;

public class Board {
	private Piece[][] boardPieces = new Piece[8][8];

	public Board() {

	}

	public void setPosition(int x, int y, Piece thePiece) {
		boardPieces[x][y] = thePiece;
	}

	public void removePosition(int x, int y) {
		boardPieces[x][y] = null;
	}

	public boolean outOfRange(int x, int y) {
		if (x < 0 || x > 7 || y < 0 || y > 7)
			return true;
		return false;
	}

	public boolean occupied(int x, int y) {
		if (boardPieces[x][y] != null)
			return true;
		return false;
	}

	public Piece getPiece(int x, int y) {
		return boardPieces[x][y];
	}

	public Piece[][] getPieces() {
		return boardPieces;
	}
}
