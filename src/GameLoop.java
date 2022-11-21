import java.util.Random;

public abstract class GameLoop {

    protected volatile GameStatus status;

    protected GameController controller;

    public GameLoop() {
        controller = new GameController();
        status = GameStatus.STOPPED;
    }

    public void run() {
        status = GameStatus.RUNNING;
        Thread gameThread = new Thread(this::processGameLoop);
        gameThread.start();
    }

    public void stop() {
        status = GameStatus.STOPPED;
    }

    public boolean isGameRunning() {
        return status == GameStatus.RUNNING;
    }

    protected void processInput() {
        try{
            var lag = new Random().nextInt(200) + 50;
            Thread.sleep(lag);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    protected void render() {
        Piece[][] board = Board.board;

        for (Piece[] pieces : board) {
            for (Piece piece : pieces) {
                System.out.print(piece.getValue() + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    protected abstract void processGameLoop();
}
