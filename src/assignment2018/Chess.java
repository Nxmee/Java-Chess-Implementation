package assignment2018;

import assignment2018.codeprovided.*;

/*
 * Chess.java 
 */

/**
 * Chess.java
 *
 * The main chess class, controls the flow of the program
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */

public class Chess {

	public static void main(String[] args) {
		// add a board and screen
		Board gameBoard = new Board();
		Display screen = new TextDisplay();

		// give each player some pieces
		Pieces blackPieces = new Pieces(gameBoard, PieceCode.BLACK);
		Pieces whitePieces = new Pieces(gameBoard, PieceCode.WHITE);

		// Player blackPlayer = new HumanPlayer("Black", blackPieces, gameBoard, null);
		// Player blackPlayer = new RandomPlayer("Black", blackPieces, gameBoard, null);
		Player blackPlayer = new AggressivePlayer("Black", blackPieces, gameBoard, null);

		Player whitePlayer = new HumanPlayer("White", whitePieces, gameBoard, null);
		// Player whitePlayer = new RandomPlayer("White", whitePieces, gameBoard,null);
		// Player whitePlayer = new AggressivePlayer("White", whitePieces,
		// gameBoard,null);

		blackPlayer.setOpponent(whitePlayer);
		whitePlayer.setOpponent(blackPlayer);

		Player activePlayer = whitePlayer;
		// while both kings are alive
		while (blackPlayer.getPieces().getPiece(blackPlayer.getPieces().getNumPieces() - 1).getValue() == PieceCode.KING
				&& whitePlayer.getPieces().getPiece(whitePlayer.getPieces().getNumPieces() - 1)
						.getValue() == PieceCode.KING) {

			screen.displayBoard(activePlayer.getPieces());
			Boolean madeMove = false;

			while (!madeMove) {
				madeMove = activePlayer.makeMove();
			}

			activePlayer = activePlayer.getOpponent();
		}
		// Display the end board
		screen.displayBoard(activePlayer.getPieces());

		// Find out who's king died
		Player winner = null;
		if (blackPlayer.getPieces().getPiece(blackPlayer.getPieces().getNumPieces() - 1).getValue() == PieceCode.KING) {
			winner = blackPlayer;
		} else {
			winner = whitePlayer;
		}
		// and crown them champion
		System.out.println(winner + " Wins!");
	}

}
