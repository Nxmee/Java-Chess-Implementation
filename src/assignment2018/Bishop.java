package assignment2018;

import java.util.*;
import assignment2018.Board;
import assignment2018.Move;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.PieceCode;

/*
 * Bishop.java 
 */

/**
 * Bishop.java
 *
 * class to represent a bishop
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class Bishop extends Piece {

	public Bishop(int ix, int iy, int c, Board b) {
		super(PieceCode.BISHOP, ix, iy, c, b);
	}

	// method implements abstract availableMoves method in Piece class
	public ArrayList<Move> availableMoves() {
		// obtain current co-ordinates
		int x = this.getX();
		int y = this.getY();

		ArrayList<Move> listMoves = new ArrayList<Move>();

		ArrayList<Move> tempMoves = null;

		for (int i = -1; i < 2; i += 2) {
			for (int j = -1; j < 2; j += 2) {
				tempMoves = checkPlace(x, y, i, j);
				if (tempMoves != null)
					listMoves.addAll(tempMoves);
			}
		}
		if (listMoves.isEmpty())
			return null;
		return listMoves;
	}

	// gets all the valid moves in a specified direction
	private ArrayList<Move> checkPlace(int x, int y, int dX, int dY) {
		// some incrementers for x and y
		int difX = dX;
		int difY = dY;

		Move theMove = null;

		ArrayList<Move> listMoves = new ArrayList<Move>();

		// go until you hit the board or a piece
		while (!getBoard().outOfRange(x + difX, y + difY) && !getBoard().occupied(x + difX, y + difY)) {
			theMove = new Move(this, x, y, x + difX, y + difY, false);
			listMoves.add(theMove);
			difX += dX;
			difY += dY;
		}

		// include a taking move if necessary
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
