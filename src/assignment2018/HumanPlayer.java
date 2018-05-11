package assignment2018;

import java.util.ArrayList;
import java.util.Scanner;

import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

/*
 * HumanPlayer.java 
 */

/**
 * HumanPlayer.java
 *
 * Represents the human interface with the chess game
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class HumanPlayer extends Player {

	public HumanPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	public boolean makeMove() {
		boolean taking = false;

		Scanner in = new Scanner(System.in);
		System.out.println(this + " to move:");
		String input = in.nextLine();

		input = input.trim();
		if (input.length() < 5)
			return false;

		// make sure the number parts of the coordinates are actually numbers
		if (!Character.isDigit(input.charAt(1)) || !Character.isDigit(input.charAt(4)))
			return false;

		int yS = Integer.parseInt(input.substring(1, 2)) - 1;
		int yE = Integer.parseInt(input.substring(4, 5)) - 1;

		int xS = (int) input.toUpperCase().charAt(0) - 65;
		int xE = (int) input.toUpperCase().charAt(3) - 65;

		// make sure neither coordinate is out of range
		if (this.getBoard().outOfRange(xS, yS) || this.getBoard().outOfRange(xE, yE))
			return false;

		// flip the y coordinate because the numbering system is dumb
		yS = 7 - yS;
		yE = 7 - yE;

		Piece movePiece = this.getBoard().getPiece(xS, yS);
		Piece endPiece = this.getBoard().getPiece(xE, yE);

		// if movePiece is empty or it's not your piece return false
		if (movePiece == null || movePiece.getColour() != this.getPieces().getPiece(0).getColour())
			return false;

		ArrayList<Move> availableMoves = movePiece.availableMoves();

		// if no moves return null
		if (availableMoves == null)
			return false;
		// make a move out of what we've got for comparison's sake
		Move instructions = new Move(movePiece, xS, yS, xE, yE, taking);

		boolean found = false;

		for (int i = 0; i < availableMoves.size() && !found; i++) {
			if (availableMoves.get(i).equals(instructions))
				found = true;
		}
		System.out.println();

		if (!found)
			return false;

		// let's actually do the move
		if (taking) {
			this.getOpponent().getPieces().delete(endPiece);
		}
		movePiece.setPosition(xE, yE);
		this.getBoard().setPosition(xE, yE, movePiece);
		this.getBoard().removePosition(xS, yS);

		return true;
	}
}
