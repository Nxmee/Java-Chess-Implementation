package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/*
 * Rook.java 
 */

/**
 * Rook.java
 *
 * Represents a rook piece
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class Rook extends Piece {

	public Rook(int ix, int iy, int c, Board b) {
		super(PieceCode.ROOK, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		ArrayList<Move> listMoves = new ArrayList<Move>();

		ArrayList<Move> tempMoves = null;

		// adds up, down, left and right moves
		for (int i = -1; i < 2; i += 2) {

			tempMoves = checkPlace(x, y, i, 0);
			if (tempMoves != null)
				listMoves.addAll(tempMoves);

			tempMoves = checkPlace(x, y, 0, i);
			if (tempMoves != null)
				listMoves.addAll(tempMoves);
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
