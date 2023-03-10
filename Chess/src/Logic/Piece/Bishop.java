package Logic.Piece;

import java.util.Objects;
import java.util.stream.IntStream;
import Logic.PieceColor;

public class Bishop extends Piece {
    public Bishop(final PieceColor color) {
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
    	
        if (Math.abs(endX - startX) != Math.abs(endY - startY)) {
            return false;
        }
        
        // Check if there are any pieces blocking the Bishop's path
        final int xDir = Integer.compare(endX, startX);
        final int yDir = Integer.compare(endY, startY);
        return IntStream.range(1, Math.abs(endX - startX))
                .mapToObj(i -> board[startX + i * xDir][startY + i * yDir])
                .allMatch(Objects::isNull)
                && (board[endX][endY] == null || !Objects.equals(board[endX][endY].getColor(), getColor()));
    }
    
    private boolean isValidPosition(final int x, final int y) {
        return x >= 0 && x <= 7 && y >= 0 && y <= 7;
    }

	@Override
	public boolean canAttack(King king, Piece[][] board) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public String getSymbol() {
        return "B";
    }
}
