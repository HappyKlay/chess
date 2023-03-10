package Logic;

class Player {
    private PieceColor color;

    public Player(PieceColor color) {
        this.color = color;
    }

    public PieceColor getColor() {
        return color;
    }

    public void makeMove(Board board) {
        int startX = 0, startY = 0, endX = 0, endY = 0;
        System.out.println("Choose piece:");
        try (Scanner scanner = new Scanner(System.in)) {
            startX = scanner.nextInt();
            startY = scanner.nextInt();

            System.out.println("Make move");
            endX   = scanner.nextInt();
            endY   = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        board.movePiece(startX, startY, endX, endY);
    }
}

