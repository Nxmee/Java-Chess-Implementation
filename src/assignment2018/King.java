package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/*
 * King.java 
 */

/**
 * King.java
 *
 * Represents the king of the chess board
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class King extends Piece {

	public King(int ix, int iy, int c, Board b) {
		super(PieceCode.KING, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();
		ArrayList<Move> listMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// check -1 and 1 in both x and y axis for moves
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {

				theMove = checkPlace(x, y, i, j);
				if (theMove != null)
					listMoves.add(theMove);
			}

		}

		if (listMoves.isEmpty())
			return null;
		return listMoves;
	}

	// checks a location to see if it's a valid move
	private Move checkPlace(int x, int y, int dX, int dY) {

		if (!getBoard().outOfRange(x + dX, y + dY)) {

			if (getBoard().occupied(x + dX, y + dY)) {

				if (getBoard().getPiece(x + dX, y + dY).getColour() != this.getColour()) {
					Move theMove = new Move(this, x, y, x + dX, y + dY, true);
					return theMove;
				}

			} else {
				Move theMove = new Move(this, x, y, x + dX, y + dY, false);
				return theMove;
			}
		}
		return null;
	}

}
