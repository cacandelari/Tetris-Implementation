import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * An Z-Shape piece in the Tetris Game.
 *
 * This piece is made up of 4 squares in the following configuration:
 *
 * Sq Sq <br>
 *    Sq <br>
 *    Sq Sq <br>
 *
 * The game piece "floats above" the Grid. The (row, col) coordinates are the
 * location of the middle Square on the side within the Grid
 *
 *
 */
public class ZShape extends AbstractPiece implements PieceInterface{

    int position = 1;

    /**
     * Creates an Z-Shape piece. See class description for actual location of r
     * and c
     *
     * @param r
     *            row location for this piece
     * @param c
     *            column location for this piece
     * @param g
     *            the grid for this game piece
     *
     */
    public ZShape(int r, int c, Grid g) {
        super();
        grid = g;
        square = new Square[PIECE_COUNT];
        ableToMove = true;

        // Create the squares
        square[0] = new Square(g, r, c - 1, Color.red, true);
        square[1] = new Square(g, r, c, Color.red, true);
        square[2] = new Square(g, r + 1, c, Color.red, true);
        square[3] = new Square(g, r + 1, c + 1, Color.red, true);
    }

    @Override
    public void rotate() {
        boolean check1 = false, check2 = false, check3 = false;

        //movement 1
        if(position == 1){
            if(square[0].canMove(Direction.UP) && square[1].canMove(Direction.UP)){
                check1 = true;
            }
            else check1 = false;

            if(square[2].canMove(Direction.LEFT)){
                check2 = true;
                check3 = true;
            }
            else{
                check2 = false;
                check3 = false;
            }
            if(check1 == true && check2 == true && check3 ==true){
                square[0].move(Direction.UP);
                square[0].move(Direction.RIGHT);
                square[2].move(Direction.LEFT);
                square[2].move(Direction.UP);
                square[3].move(Direction.LEFT);
                square[3].move(Direction.LEFT);
                position = 2;

                //These two checks are used for both so they need to be returned to false.
                check1 = false;
                check2 = false;
            }
        }


        else if(position == 2){
            if(square[0].canMove(Direction.LEFT)){
                check1 = true;
            }
            if(square[3].canMove(Direction.RIGHT)){
                check2 = true;
            }

        }
        if(check1 ==true && check2==true){
            square[0].move(Direction.LEFT);
            square[3].move(Direction.RIGHT);
            square[2].move(Direction.DOWN);
            square[0].move(Direction.DOWN);
            if(square[3].canMove(Direction.RIGHT)){
                square[3].move(Direction.RIGHT);
                square[2].move(Direction.RIGHT);
                position = 1;

            }
            //if 3 can't move to the right again, the move resets.
            else{
                square[0].move(Direction.UP);
                square[2].move(Direction.UP);
                square[3].move(Direction.LEFT);
                square[0].move(Direction.RIGHT);
                position = 2;
            }
        }

    }
}
