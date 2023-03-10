package Logic.Piece;

import Logic.PieceColor;

public class King extends Piece {
	
	protected int X = 0;
	protected int Y = 0;
	
    public King(final PieceColor color) {
        super(color);
        if (color == PieceColor.BLACK) {
			X = 7;
			Y = 4;
		} 
        else {
        	X = 0;
        	Y = 4;
        }
    }
    
    @Override
    public boolean isValidMove(Piece[][] board, int startX, int startY, int endX, int endY) {
    	if (!isValidPosition(endX, endY)) {
            return false;
        }
    	
    	if (startX == endX && startY == endY) {
            return false;
        }
    	
    	if (Math.abs(endX - startX) <= 1 && Math.abs(endY - endY) <= 1) {
    		if (board[endX][endY] == null || board[endX][endY].getColor() != this.getColor()) {
    	    	X = endX;
    	    	Y = endY;
                return true;
            }
    	}
    	return false;
    }
    
    private boolean isValidPosition(final int x, final int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }
    
    
    
    public int getX() {
    	return X;
    }
    
    public int getY() {
    	return Y;
    }

	@Override
	public boolean canAttack(King king, Piece[][] board) {
		// TODO Auto-generated method stub
		return false;
	}
}