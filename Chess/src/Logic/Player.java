package Logic;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private PieceColor color;
    private Scanner scanner;

    public Player(PieceColor color) {
        this.color = color;
        this.scanner = new Scanner(System.in);
    }

    public PieceColor getColor() {
        return color;
    }

    public void makeMove(Board board) {
        int startX = 0, startY = 0, endX = 0, endY = 0;
        try {
            System.out.println("Choose piece:");

            System.out.print("X coordinate: ");
            startX = scanner.nextInt();

            System.out.print("Y coordinate: ");
            startY = scanner.nextInt();

            System.out.println("Make move");

            System.out.print("X coordinate: ");
            endX = scanner.nextInt();

            System.out.print("Y coordinate: ");
            endY = scanner.nextInt();
            System.out.println("\n===================================================\n");
            board.movePiece(startX, startY, endX, endY);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter integer values only.");
            scanner.next();
            makeMove(board);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        scanner.close();
    }
}

