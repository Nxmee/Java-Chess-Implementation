package assignment2018;

import assignment2018.codeprovided.Piece;

/*
 * Move.java 
 */

/**
 * Move.java
 *
 * Stores the data for a move
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class Move {

	private Piece thePiece;

	// start and end x variables
	private int xS;
	private int xE;

	// start and end y variables
	private int yS;
	private int yE;

	private boolean take;

	public Move(Piece boardPiece, int startX, int startY, int endX, int endY, boolean taking) {
		thePiece = boardPiece;
		xS = startX;
		xE = endX;
		yS = startY;
		yE = endY;
		take = taking;
	}

	public Piece getPiece() {
		return thePiece;
	}

	public int getStartX() {
		return xS;
	}

	public int getStartY() {
		return yS;
	}

	public int getEndX() {
		return xE;
	}

	public int getEndY() {
		return yE;
	}

	public boolean getTake() {
		return take;
	}

	public boolean equals(Move compareMove) {
		if (compareMove.getPiece() == this.getPiece() && compareMove.getStartX() == this.getStartX()
				&& compareMove.getStartY() == this.getStartY() && compareMove.getEndX() == this.getEndX()
				&& compareMove.getEndY() == this.getEndY())
			return true;
		return false;
	}

	public String toString() {
		return "" + thePiece + ": " + xS + ", " + yS + " -> " + xE + ", " + yE;
	}
}
