package assignment2018;

import assignment2018.codeprovided.Display;
import assignment2018.codeprovided.Piece;
import assignment2018.codeprovided.Pieces;

/*
 * TextDisplay.java 
 */

/**
 * TextDisplay.java
 *
 * Displays the game on the console window
 *
 * @author Christopher Hart (chart1@sheffield.ac.uk)
 */


public class TextDisplay implements Display {
	Board gameBoard = null;
	public void displayBoard(Pieces myPieces) {
		Board gameBoard = myPieces.getPiece(myPieces.getNumPieces() - 1).getBoard();
		Piece[][] boardPieces = gameBoard.getPieces();
		System.out.println(" |ABCDEFGH");
		System.out.println("----------");
		for (int y = 0; y < 8; y++) {
			System.out.print((8-y) + "|");
			for(int x = 0; x < 8; x++) {
				if (boardPieces[x][y] != null) {
					System.out.print(boardPieces[x][y]);
				}else {
					System.out.print(".");
				}
				
			}
			System.out.println();
		}
		System.out.println();
	}
}
