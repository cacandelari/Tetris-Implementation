import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 * An Bar-Shape piece in the Tetris Game.
 *
 * This piece is made up of 4 squares in the following configuration:
 *
 * Sq Sq Sq Sq <br>
 *
 * The game piece "floats above" the Grid. The (row, col) coordinates are the
 * location of the middle Square on the side within the Grid
 *
 *
 */
public class BarShape extends AbstractPiece implements PieceInterface{

    int position = 1;
    /**
     * Creates an Bar-Shape piece. See class description for actual location of r
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
    public BarShape(int r, int c, Grid g) {
        super();
        grid = g;
        square = new Square[PIECE_COUNT];
        ableToMove = true;

        // Create the squares
        square[0] = new Square(g, r, c-1 , Color.cyan, true);
        square[1] = new Square(g, r, c, Color.cyan, true);
        square[2] = new Square(g, r, c + 1, Color.cyan, true);
        square[3] = new Square(g, r , c + 2, Color.cyan, true);
    }

    @Override
    public void rotate() {
        boolean check1 = false, check2 = false, check3 = false;

        //rotation1
        if(position == 1){
            if(square[0].canMove(Direction.UP) && square[1].canMove(Direction.UP)){
                check1 = true;
            }
            if(square[1].canMove(Direction.DOWN) && square[2].canMove(Direction.DOWN)){
                check2 = true;
            }
            if(square[3].canMove(Direction.DOWN)){
                check3 = true;
            }
            if(check1 ==true && check2==true && check3==true){
                square[3].move(Direction.DOWN);
                square[3].move(Direction.LEFT);
                square[3].move(Direction.LEFT);

                if(square[3].canMove(Direction.DOWN)){
                    square[3].move(Direction.DOWN);
                    square[0].move(Direction.UP);
                    square[0].move(Direction.RIGHT);
                    square[2].move(Direction.DOWN);
                    square[2].move(Direction.LEFT);

                    check1=false;
                    check2=false;
                    check3=false;

                    position =2;
                }
                else{

                    //if 3 can't move down, reset the move back to the original position
                    square[3].move(Direction.RIGHT);
                    square[3].move(Direction.RIGHT);
                    square[3].move(Direction.UP);

                    check1=false;
                    check2=false;
                    check3=false;

                    position = 1;
                }
            }
        }

        //rotation back
        else if(position == 2){
            if(square[0].canMove(Direction.LEFT) && square[1].canMove(Direction.LEFT)){
                check1 = true;
            }
            if(square[1].canMove(Direction.RIGHT) && square[2].canMove(Direction.RIGHT)){
                check2 = true;
            }
            if(square[3].canMove(Direction.RIGHT)){
                check3 = true;
            }
            if(check1==true && check2==true && check3==true){
                square[3].move(Direction.RIGHT);
                square[3].move(Direction.UP);
                square[3].move(Direction.UP);
                if(square[3].canMove(Direction.RIGHT)){
                    square[3].move(Direction.RIGHT);
                    square[0].move(Direction.LEFT);
                    square[0].move(Direction.DOWN);
                    square[2].move(Direction.RIGHT);
                    square[2].move(Direction.UP);

                    check1=false;
                    check2=false;
                    check3=false;

                    position = 1;
                }
                //if square 3 can't move right the second time.
                else{
                    square[3].move(Direction.DOWN);
                    square[3].move(Direction.DOWN);
                    square[3].move(Direction.LEFT);

                    check1 = false;
                    check2=false;
                    check3=false;

                    position = 2;
                }
            }
        }
    }
}
