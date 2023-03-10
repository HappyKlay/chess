package Logic.Piece;

import Logic.PieceColor;

public abstract class Piece {
    protected PieceColor color;

    public Piece(PieceColor color) {
        this.color = color;
    }

    public abstract boolean isValidMove(Piece[][] board, int startX, int startY, int endX, int endY);

    public PieceColor getColor() {
        return color;
    }

	public abstract boolean canAttack(King king, Piece[][] board);
}
