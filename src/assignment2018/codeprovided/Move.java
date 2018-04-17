package assignment2018.codeprovided;

public class Move {
	private Piece thePiece;
	private int xS;
	private int xE;
	private int yS;
	private int yE;
	private boolean take;
	
	public Move (Piece boardPiece, int startX, int startY, int endX, int endY, boolean taking) {
		thePiece = boardPiece;
		xS = startX;
		xE = endX;
		yS = startY;
		yE = endY;
		take = taking;
	}
	
}
