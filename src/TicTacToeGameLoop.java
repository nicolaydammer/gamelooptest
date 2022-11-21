public class TicTacToeGameLoop extends GameLoop {
    @Override
    protected void processGameLoop() {
        while (isGameRunning()) {
            processInput();
            update();
            render();
        }
    }

    protected void update() {

        if (Board.isFull()) {
            this.controller.board.reset();
        }

        int[][] nextMove = controller.calculateNextMove();

        controller.setBoardPiece(nextMove, GameController.playerTurn);

        GameController.switchTurn();
    }
}
