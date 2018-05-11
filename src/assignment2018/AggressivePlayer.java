package assignment2018;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import assignment2018.codeprovided.Pieces;
import assignment2018.codeprovided.Player;

/*
 * AggressivePlayer.java 
 */

/**
 * AggressivePlayer.java
 *
 * Represents a player that tries to pick the move that has the best take
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class AggressivePlayer extends RandomPlayer {

	public AggressivePlayer(String n, Pieces p, Board b, Player o) {
		super(n, p, b, o);
	}

	public boolean makeMove() {

		// get all the moves
		ArrayList<Move> moveList = super.getAllMoves();
		// then get all the aggressive moves
		ArrayList<Move> aggressiveMoves = new ArrayList<Move>();
		for (int i = 0; i < moveList.size(); i++) {
			if (moveList.get(i).getTake()) {
				aggressiveMoves.add(moveList.get(i));
			}
		}
		// Choose a move either from random or most aggressive
		Move chosenMove = null;
		if (aggressiveMoves.size() == 0) {

			chosenMove = getRandomMove();

		} else {

			int biggestTake = 0;
			int biggestTakeLoc = 0;

			for (int i = 0; i < aggressiveMoves.size(); i++) {

				if (aggressiveMoves.get(i).getPiece().getValue() > biggestTake) {
					biggestTake = aggressiveMoves.get(i).getPiece().getValue();
					biggestTakeLoc = i;
				}

			}

			chosenMove = aggressiveMoves.get(biggestTakeLoc);
		}
		// if it's a taking move then delete their piece
		if (chosenMove.getTake()) {
			this.getOpponent().getPieces().delete(this.getBoard().getPiece(chosenMove.getEndX(), chosenMove.getEndY()));
		}

		chosenMove.getPiece().setPosition(chosenMove.getEndX(), chosenMove.getEndY());
		this.getBoard().setPosition(chosenMove.getEndX(), chosenMove.getEndY(), chosenMove.getPiece());
		this.getBoard().removePosition(chosenMove.getStartX(), chosenMove.getStartY());

		return true;

	}
}
