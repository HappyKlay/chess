package Logic;

public class ChessGame {
    private final int NUM_OF_PLAYERS = 2;
    private Board board = new Board();
    private Player[] players = new Player[NUM_OF_PLAYERS];
    private Player currentPlayer;

    public ChessGame(Player player1, Player player2) {
        this.players = new Player[]{player1, player2};
        currentPlayer = players[0];
    }

    public void start() {
        while (!board.isWinner()) {
            board.printBoard();
            currentPlayer.makeMove(board);
            board.printBoard();
            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }
}
