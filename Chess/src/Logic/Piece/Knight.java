package Logic.Piece;

import Logic.PieceColor;

public class Knight extends Piece {
    public Knight(final PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Piece[][] board, int startX, int startY, int endX, int endY) {
    	if (!isValidPosition(endX, endY)) {
            return false;
        }

        int dx = Math.abs(endX - startX);
        int dy = Math.abs(endY - startY);
        if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
            if (board[endX][endY] == null || board[endX][endY].getColor() != board[startX][startY].getColor()) {
                return true;
            }
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
