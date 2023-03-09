package Chess.Piece;

import Chess.Board;

public class Empty extends Piece {
    public Empty() {
        super(null);
    }

    public boolean isValidMove(Piece[][] board, int startX, int startY, int endX, int endY) {
		return false;
    }
    
	private boolean isPathClear(int startX, int startY, int endX, int endY) {
    	
		return false;
    }
}
