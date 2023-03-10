package Logic.Piece;

import Logic.PieceColor;

public class Rook extends Piece {
	public Rook(final PieceColor color) {
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

		if (startX != endX && startY != endY) {
			return false;
		}

		if (startX == endX) {
			int step = Integer.compare(endY, startY);
			for (int y = startY + step; y != endY; y += step) {
				if (board[startX][y] != null) {
					return false;
				}
			}
		} else {
			int step = Integer.compare(endX, startX);
			for (int x = startX + step; x != endX; x += step) {
				if (board[x][startY] != null) {
					return false;
				}
			}
		}

		return true;
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
