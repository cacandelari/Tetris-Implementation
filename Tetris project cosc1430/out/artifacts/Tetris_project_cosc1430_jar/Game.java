import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

/**
 * Manages the game Tetris. Keeps track of the current piece and the grid.
 * Updates the display whenever the state of the game has changed.
 *
 *
 */
public class Game {

    private Grid grid; // the grid that makes up the Tetris board

    private Tetris display; // the visual for the Tetris game

    private AbstractPiece piece; // the current piece that is dropping

    private boolean isOver; // has the game finished?

    public int GameScore;

    public static int endScore;


    /**
     * Creates a Tetris game
     *
     * @param //Tetris
     *            the display
     */
    public Game(Tetris display) {
        grid = new Grid();
        this.display = display;
        Random rand = new Random();
        int x = rand.nextInt(7) + 1;
        //int x = 6;
        if(x == 1) {
            piece = new ZShape(1, Grid.WIDTH / 2 - 1, grid);
        }
        if(x == 2) {
            piece = new SquareShape(1, Grid.WIDTH / 2, grid);
        }
        if(x == 3) {
            piece = new JShape(1, Grid.WIDTH / 2, grid);
        }
        if(x == 4) {
            piece = new TShape(1, Grid.WIDTH / 2 - 1, grid);
        }
        if(x == 5) {
            piece = new SShape(1, Grid.WIDTH / 2 - 1, grid);
        }
        if(x == 6) {
            piece = new BarShape(1, Grid.WIDTH / 2 - 1, grid);
        }
        if(x == 7) {
            piece = new LShape(1, Grid.WIDTH / 2 - 1, grid);
        }
        isOver = false;
    }

    /**
     * Draws the current state of the game
     *
     * @param g
     *            the Graphics context on which to draw
     */
    public void draw(Graphics g) {
        grid.draw(g);
        if (piece != null) {
            piece.draw(g);
        }
    }

    /**
     * Moves the piece in the given direction
     *
     * //@param the
     *            direction to move
     */
    public void movePiece(Direction direction) {
        if (piece != null) {

            piece.move(direction);
        }
        updatePiece();
        //grid.checkRows();
        GameScore = GameScore + grid.checkRows();
        display.update();
    }

    /**
     * Returns true if the game is over
     */
    public boolean isGameOver() {
        // game is over if the piece occupies the same space as some non-empty
        // part of the grid. Usually happens when a new piece is made
        if (piece == null) {
            return false;
        }

        // check if game is already over
        if (isOver) {
            return true;
        }

        // check every part of the piece
        Point[] p = piece.getLocations();
        for (int i = 0; i < p.length; i++) {
            if (grid.isSet((int) p[i].getX(), (int) p[i].getY())) {
                isOver = true;
                endScore = GameScore;
                return true;
            }
        }
        return false;
    }

    public static int getEndScore(){
        return endScore;
    }

    /** Updates the piece */
    private void updatePiece() {
        if (piece == null) {
            //create new LShape piece here
            Random rand = new Random();
            int x = rand.nextInt(7) + 1;
            //int x = 6;
            if(x == 1) {
                piece = new ZShape(1, Grid.WIDTH / 2 - 1, grid);
            }
            if(x == 2) {
                piece = new SquareShape(1, Grid.WIDTH / 2, grid);
            }
            if(x == 3) {
                piece = new JShape(1, Grid.WIDTH / 2, grid);
            }
            if(x == 4) {
                piece = new TShape(1, Grid.WIDTH / 2 - 1, grid);
            }
            if(x == 5) {
                piece = new SShape(1, Grid.WIDTH / 2 - 1, grid);
            }
            if(x == 6) {
                piece = new BarShape(1, Grid.WIDTH / 2 - 1, grid);
            }
            if(x == 7) {
                piece = new LShape(1, Grid.WIDTH / 2 - 1, grid);
            }
        }

        // set Grid positions corresponding to frozen piece
        // and then release the piece
        else if (!piece.canMove(Direction.DOWN)) {
            Point[] p = piece.getLocations();
            Color c = piece.getColor();
            for (int i = 0; i < p.length; i++) {
                grid.set((int) p[i].getX(), (int) p[i].getY(), c);
            }
            piece = null;
        }

    }

    /** Rotate the piece*/
    public void rotatePiece()
    {
        if (piece != null) {
            piece.rotate();
        }
        updatePiece();
        //grid.checkRows();
        GameScore = GameScore + grid.checkRows();
        //System.out.println("GameScore: " + GameScore + " : " +  grid.checkRows());
        display.update();
    }
}
