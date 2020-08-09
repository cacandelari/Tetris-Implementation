import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;


public abstract class AbstractPiece implements PieceInterface {
    protected boolean ableToMove; // can this piece move

    //protected boolean ableToRot;//can this piece rotate

    protected Square[] square; // the squares that make up this piece

    // Made up of PIECE_COUNT squares
    protected Grid grid; // the board this piece is on

    // number of squares in one Tetris game piece
    protected static final int PIECE_COUNT = 4;

    protected int position = 0;

    public AbstractPiece(){}

    /**
     * Draws the piece on the given Graphics context
     */
    public void draw(Graphics g)
    {
        for (int i = 0; i < PIECE_COUNT; i++) {
            square[i].draw(g);
        }
    }

    /**
     * Moves the piece if possible Freeze the piece if it cannot move down
     * anymore
     *
     * @param direction
     *            the direction to move
     */
    public void move(Direction direction)
    {
        if (canMove(direction)) {
            for (int i = 0; i < PIECE_COUNT; i++)
                square[i].move(direction);
        }
        // if we couldn't move, see if because we're at the bottom
        else if (direction == Direction.DOWN) {
            ableToMove = false;
        }
    }

    /**
     * Returns the (row,col) grid coordinates occupied by this Piece
     *
     * @return an Array of (row,col) Points
     */
    public Point[] getLocations()
    {
        Point[] points = new Point[PIECE_COUNT];
        for (int i = 0; i < PIECE_COUNT; i++) {
            points[i] = new Point(square[i].getRow(), square[i].getCol());
        }
        return points;
    }

    /**
     * Return the color of this piece
     */
    public Color getColor()
    {
        // all squares of this piece have the same color
        return square[0].getColor();
    }

    /**
     * Returns if this piece can move in the given direction
     *
     */
    public boolean canMove(Direction direction)
    {
        if (!ableToMove)
            return false;

        // Each square must be able to move in that direction
        boolean answer = true;
        for (int i = 0; i < PIECE_COUNT; i++) {
            answer = answer && square[i].canMove(direction);
        }

        return answer;
    }

    /**
     * Rotate the Piece
     *
     */

    public void rotate(){

        /**
         * each piece has each of their rotations hard coded.
        *  each piece begins in position 1
        *  if they go through the rotation function, they are moved to position 2
        *  and so on
        *  and have code corresponding to the movements needed to move to each position.
         *
        */


    }

    //code that didn't work if the piece was up against a wall or another piece
    //VVVVV
    /*
    public void rotate()
    {
        for (int i = 0; i < PIECE_COUNT; i++) {
            if(square[i].getRow() >= 0 && square[i].getRow() < Grid.HEIGHT && square[i].getCol() >= 0 && square[i].getCol() < Grid.WIDTH){
                if(i !=1) {
                    //make sure to check if the square can be moved in BOTH directions before moving in EITHER direction
                    //RIGHT, RIGHT
                    if (square[i].getRow() == square[1].getRow() - 1 && square[i].getCol() == square[1].getCol() - 1) {
                        if (canMove(Direction.RIGHT) && canMove(Direction.RIGHT)) {
                            square[i].move(Direction.RIGHT);
                            square[i].move(Direction.RIGHT);
                        }
                    }
                    //L square 0
                    //RIGHT, DOWN
                    else if (square[i].getRow() == square[1].getRow() - 1 && square[i].getCol() == square[1].getCol() + 0) {
                        if (canMove(Direction.RIGHT) && canMove(Direction.DOWN)) {
                            square[i].move(Direction.RIGHT);
                            square[i].move(Direction.DOWN);

                        }

                    }
                    //DOWN, DOWN
                    else if (square[i].getRow() == square[1].getRow() - 1 && square[i].getCol() == square[1].getCol() + 1) {
                        if (canMove(Direction.DOWN) && canMove(Direction.DOWN)) {
                            square[i].move(Direction.DOWN);
                            square[i].move(Direction.DOWN);
                        }
                    }
                    //UP, RIGHT
                    else if (square[i].getRow() == square[1].getRow() + 0 && square[i].getCol() == square[1].getCol() - 1) {
                        if (canMove(Direction.UP) && canMove(Direction.RIGHT)) {
                            square[i].move(Direction.UP);
                            square[i].move(Direction.RIGHT);
                        }
                    }

                    //DOWN, LEFT
                    else if (square[i].getRow() == square[1].getRow() && square[i].getCol() == square[1].getCol() + 1) {
                        if (canMove(Direction.DOWN) && canMove(Direction.LEFT)) {
                            square[i].move(Direction.DOWN);
                            square[i].move(Direction.LEFT);
                        }
                    }

                    //UP, UP
                    else if (square[i].getRow() == square[1].getRow() + 1 && square[i].getCol() == square[1].getCol() - 1) {
                        if (canMove(Direction.UP) && canMove(Direction.UP)) {
                            square[i].move(Direction.UP);
                            square[i].move(Direction.UP);
                        }
                    }
                    //L square 2
                    //LEFT, UP
                    else if (square[i].getRow() == square[1].getRow() + 1 && square[i].getCol() == square[1].getCol() + 0) {
                        if (canMove(Direction.LEFT) && canMove(Direction.UP)) {
                            square[i].move(Direction.LEFT);
                            square[i].move(Direction.UP);
                        }
                    }
                    //L square3
                    //LEFT LEFT
                    else if (square[i].getRow() == square[1].getRow() + 1 && square[i].getCol() == square[1].getCol() + 1) {
                        if (canMove(Direction.LEFT) && canMove(Direction.LEFT)) {
                            square[i].move(Direction.LEFT);
                            square[i].move(Direction.LEFT);
                        }
                    }
                }//if !1
            }
        }//for loop end
    }//method end
    */
}

