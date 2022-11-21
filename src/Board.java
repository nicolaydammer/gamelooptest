public class Board {
    public static Piece[][] board;

    Board(int sizeX, int sizeY) {
        board = new Piece[sizeX][sizeY];

        this.init();
    }

    private void init() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Piece(' ');
            }
        }
    }

    public void reset() {
        init();
    }

    public static boolean isFull() {
        boolean full = true;

        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                if (piece.getValue() == ' ') {
                    full = false;
                    break;
                }
            }
        }

        return full;
    }
}
