package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/*
 * Knight.java 
 */

/**
 * Knight.java
 *
 * Represents the knight in the chess game
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class Knight extends Piece {

	public Knight(int ix, int iy, int c, Board b) {
		super(PieceCode.KNIGHT, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();
		ArrayList<Move> listMoves = new ArrayList<Move>();

		// set up m to refer to a Move object
		Move theMove = null;

		// check all the 2,1 combinations of moves
		for (int i = -1; i <= 1; i += 2) {

			for (int j = -2; j <= 2; j += 4) {

				theMove = getMove(x, y, i, j);
				if (theMove != null)
					listMoves.add(theMove);
				theMove = getMove(x, y, j, i);
				if (theMove != null)
					listMoves.add(theMove);
			}
		}

		if (listMoves.isEmpty())
			return null;
		return listMoves;
	}

	private Move getMove(int x, int y, int dX, int dY) {
		Move theMove = null;
		if (!getBoard().outOfRange(x + dX, y + dY)) {

			if (getBoard().occupied(x + dX, y + dY)) {

				if (getBoard().getPiece(x + dX, y + dY).getColour() != this.getColour()) {
					theMove = new Move(this, x, y, x + dX, y + dY, true);
					return theMove;
				}

			} else {
				theMove = new Move(this, x, y, x + dX, y + dY, false);
				return theMove;
			}

		}
		return null;
	}

}
