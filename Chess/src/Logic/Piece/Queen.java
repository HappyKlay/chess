package Logic.Piece;

import Logic.PieceColor;

public class Queen extends Piece {
    public Queen(final PieceColor color) {
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
    	
        if (startX == endX || startY == endY) {
            int min = Math.min(startY, endY);
            int max = Math.max(startY, endY);
            for (int i = min + 1; i < max; i++) {
                if (board[startX][i] != null) {
                    return false;
                }
            }
            min = Math.min(startX, endX);
            max = Math.max(startX, endX);
            for (int i = min + 1; i < max; i++) {
                if (board[i][startY] != null) {
                    return false;
                }
            }
            return true;
        }

        if (Math.abs(startX - endX) == Math.abs(startY - endY)) {
            int x = startX < endX ? 1 : -1;
            int y = startY < endY ? 1 : -1;
            int i = startX + x;
            int j = startY + y;
            while (i != endX && j != endY) {
                if (board[i][j] != null) {
                    return false;
                }
                i += x;
                j += y;
            }
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
