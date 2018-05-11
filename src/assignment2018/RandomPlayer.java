package assignment2018;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

/*
 * RandomPlayer.java 
 */

/**
 * RandomPlayer.java
 *
 * Represents a player that picks a random move
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class RandomPlayer extends Player {
	Random r = new Random();

	public RandomPlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	public boolean makeMove() {

		// gets a random move
		Move chosenMove = getRandomMove();

		// implements it
		if (chosenMove.getTake()) {
			this.getOpponent().getPieces().delete(this.getBoard().getPiece(chosenMove.getEndX(), chosenMove.getEndY()));
		}
		chosenMove.getPiece().setPosition(chosenMove.getEndX(), chosenMove.getEndY());
		this.getBoard().setPosition(chosenMove.getEndX(), chosenMove.getEndY(), chosenMove.getPiece());
		this.getBoard().removePosition(chosenMove.getStartX(), chosenMove.getStartY());
		return true;
	}

	public Move getRandomMove() {
		ArrayList<Move> moveList = getAllMoves();
		int chosenMoveInt = r.nextInt(moveList.size());
		Move chosenMove = moveList.get(chosenMoveInt);
		return chosenMove;
	}

	// puts all the moves for all the pieces in an ArrayList
	public ArrayList<Move> getAllMoves() {
		ArrayList<Move> availableMoves = new ArrayList<Move>();
		for (int i = 0; i < this.getPieces().getNumPieces(); i++) {
			ArrayList<Move> moreMoves = this.getPieces().getPiece(i).availableMoves();
			if (moreMoves != null)
				availableMoves.addAll(moreMoves);
		}
		return availableMoves;
	}
}
