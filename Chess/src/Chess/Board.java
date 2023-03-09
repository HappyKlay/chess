package Chess;

import Chess.Piece.*;

public class Board {
	private Piece[][] board;

	public Board() {
		// Set up the white pieces
		board[0][0] = new Rook(PieceColor.WHITE);
		board[0][1] = new Knight(PieceColor.WHITE);
		board[0][2] = new Bishop(PieceColor.WHITE);
		board[0][3] = new Queen(PieceColor.WHITE);
		board[0][4] = new King(PieceColor.WHITE);
		board[0][5] = new Bishop(PieceColor.WHITE);
		board[0][6] = new Knight(PieceColor.WHITE);
		board[0][7] = new Rook(PieceColor.WHITE);
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(PieceColor.WHITE);
		}

		// Set up the empty squares
		for (int i = 2; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Empty();
			}
		}

		// Set up the black pieces
		board[7][0] = new Rook(PieceColor.BLACK);
		board[7][1] = new Knight(PieceColor.BLACK);
		board[7][2] = new Bishop(PieceColor.BLACK);
		board[7][3] = new Queen(PieceColor.BLACK);
		board[7][4] = new King(PieceColor.BLACK);
		board[7][5] = new Bishop(PieceColor.BLACK);
		board[7][6] = new Knight(PieceColor.BLACK);
		board[7][7] = new Rook(PieceColor.BLACK);
		for (int i = 0; i < 8; i++) {
			board[6][i] = new Pawn(PieceColor.BLACK);
		}

	}

	public Piece getPiece(int x, int y) {
		return board[x][y];
	}

	public void movePiece(int startX, int startY, int endX, int endY) {

		if (isKingInCheck(board[endX][endY].getColor())) {
			throw new IllegalStateException("Cannot move piece while in check");
		}

		if (isKingInCheckmate(board[endX][endY].getColor())) {

		}

		if (isValidMove(startX, startY, endX, endY)) {
			board[endX][endY] = board[startX][startY];
			board[startX][startY] = new Empty();
		}
	}

	private boolean isValidMove(int startX, int startY, int endX, int endY) {
		return board[startX][startY].isValidMove(board, startX, startY, endX, endY);
	}

	private boolean isKingInCheck(PieceColor color) {
		King king = findKing(color);
		if (king == null) {
			throw new IllegalStateException("Could not find king on the board");
		}

		for (Piece[] row : board) {
			for (Piece piece : row) {
				if (piece != null && piece.getColor() != color) {
					if (piece.canAttack(king, board)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private King findKing(PieceColor color) {
		for (Piece[] row : board) {
			for (Piece piece : row) {
				if (piece instanceof King && piece.getColor() == color) {
					return (King) piece;
				}
			}
		}
		
		return null;
	}

	private boolean isKingInCheckmate(PieceColor color) {
	    if (!isKingInCheck(color)) {
	        return false;
	    }

	    King king = findKing(color);
	    int startX = king.getX();
	    int startY = king.getY();

	    for (int x = startX - 1; x <= startX + 1; x++) {
	        for (int y = startY - 1; y <= startY + 1; y++) {
	            if (x == startX && y == startY) {
	                continue; 
	            }
	            if (x < 0 || x > 7 || y < 0 || y > 7) {
	                continue; 
	            }
	            if (board[x][y] != null && board[x][y].getColor() == color) {
	                continue; 
	            }
	            Piece captured = board[x][y];
	            board[x][y] = king;
	            board[startX][startY] = null;
	            boolean stillInCheck = isKingInCheck(color);
	            board[startX][startY] = king;
	            board[x][y] = captured;
	            if (!stillInCheck) {
	                return false; 
	            }
	        }
	    }

	    return true;
	}
}
