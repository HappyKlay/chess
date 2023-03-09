package Chess.Piece;

import Chess.PieceColor;

public class Pawn extends Piece {
    public Pawn(final PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Piece[][] board, int startX, int startY, int endX, int endY) {
    	if (!isValidPosition(endX, endY)) {
            return false;
        }
    	if (startX == endX && startY == endY) {
            return false;
        }
    	if (color == PieceColor.BLACK &&
                ((startX == 6 && endX == startX - 2 && startY == endY) || ((endY == startY || endY == startY + 1 || endY == startY - 1) && endX == startX - 1))) {
            return true;
        } 
        else if (color == PieceColor.WHITE &&
                ((startX == 1 && endX == startX + 2 && startY == endY) || ((endY == startY || endY == startY + 1 || endY == startY - 1) && endX == startX + 1))) {
            return true;
        }
    	return false;
    }

    @Override
    public boolean canAttack(King king, Piece[][] board) {
        // TODO Auto-generated method stub
        return false;
    }
    
    private boolean isValidPosition(final int x, final int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }
}
