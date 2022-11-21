public class GameController {
    protected final Board board;

    public static char playerTurn = 'O';

    public GameController() {
        this.board = new Board(3, 3);
    }

    public int[][] calculateNextMove() {
        int[][] returnValue = new int[2][2];

        Piece[][] board = Board.board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getValue() == ' ') {
                    returnValue[0][0] = i;
                    returnValue[0][1] = j;
                }
            }
        }

        return returnValue;
    }

    public void setBoardPiece(int[][] coordinate, char value) {
        Board.board[coordinate[0][0]][coordinate[0][1]].setValue(value);
    }

    public static void switchTurn() {
        if (playerTurn == 'O') {
            playerTurn = 'X';
        } else {
            playerTurn = 'O';
        }
    }
}
