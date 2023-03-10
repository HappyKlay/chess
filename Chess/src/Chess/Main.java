package Chess;
import Logic.ChessGame;

public class Main {
	public static void main(String[] args) {
		Player player1 = new Player(PieceColor.WHITE);
		Player player2 = new Player(PieceColor.BLACK);
		ChessGame chess = new ChessGame(player1, player2);
		chess.start();
	}
}
