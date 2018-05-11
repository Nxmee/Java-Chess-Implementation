package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/*
 * Queen.java 
 */

/**
 * Queen.java
 *
 * Represents the queen piece
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class Queen extends Piece {

	public Queen(int ix, int iy, int c, Board b) {
		super(PieceCode.QUEEN, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		ArrayList<Move> listMoves = new ArrayList<Move>();

		ArrayList<Move> tempMoves = null;

		// check all directions for moves
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				tempMoves = checkPlace(x, y, i, j);
				if (tempMoves != null)
					listMoves.addAll(tempMoves);
			}
		}
		if (listMoves.isEmpty())
			return null;
		return listMoves;
	}

	private ArrayList<Move> checkPlace(int x, int y, int dX, int dY) {
		int difX = dX;
		int difY = dY;

		Move theMove = null;

		ArrayList<Move> listMoves = new ArrayList<Move>();

		while (!getBoard().outOfRange(x + difX, y + difY) && !getBoard().occupied(x + difX, y + difY)) {
			theMove = new Move(this, x, y, x + difX, y + difY, false);
			listMoves.add(theMove);
			difX += dX;
			difY += dY;
		}
		if (!getBoard().outOfRange(x + difX, y + difY) && getBoard().occupied(x + difX, y + difY)
				&& getBoard().getPiece(x + difX, y + difY).getColour() != this.getColour()) {
			theMove = new Move(this, x, y, x + difX, y + difY, true);
			listMoves.add(theMove);
		}
		if (listMoves.isEmpty())
			return null;
		return listMoves;
	}

}
