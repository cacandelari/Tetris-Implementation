import java.awt.Color;
        import java.awt.Graphics;
        import java.awt.Point;

/**
 * An J-Shape piece in the Tetris Game.
 *
 * This piece is made up of 4 squares in the following configuration:
 *    Sq
 *    Sq <br>
 * Sq Sq <br>
 *
 * The game piece "floats above" the Grid. The (row, col) coordinates are the
 * location of the middle Square on the side within the Grid
 *
 *
 */
public class JShape extends AbstractPiece implements PieceInterface{

    int position = 1;
    /**
     * Creates an J-Shape piece. See class description for actual location of r
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
    public JShape(int r, int c, Grid g) {
        super();
        grid = g;
        square = new Square[PIECE_COUNT];
        ableToMove = true;

        // Create the squares
        square[0] = new Square(g, r-1, c, Color.blue, true);
        square[1] = new Square(g, r, c, Color.blue, true);
        square[2] = new Square(g, r+ 1, c, Color.blue, true);
        square[3] = new Square(g, r + 1, c - 1, Color.blue, true);
    }

    @Override
    public void rotate() {
        boolean check1 = false, check2 = false, check3 = false;

        //rotation1
        if(position == 1){
            if(square[0].canMove(Direction.RIGHT) && square[1].canMove(Direction.RIGHT)){
                check1 = true;
            }
            if(square[3].canMove(Direction.UP)){
                check2 = true;
            }
            if(square[0].canMove(Direction.LEFT)){
                check3 = true;
            }
            if(check1==true && check2==true && check3==true){
                square[0].move(Direction.RIGHT);
                square[0].move(Direction.DOWN);
                square[3].move(Direction.UP);
                square[3].move(Direction.UP);
                square[2].move(Direction.LEFT);
                square[2].move(Direction.UP);

                position = 2;
            }
        }

        //rotation 2
        else if(position == 2){
            if(square[0].canMove(Direction.DOWN) && square[1].canMove(Direction.DOWN)){
                check1 = true;
            }
            if(square[3].canMove(Direction.RIGHT)){
                check2 = true;
            }
            if(square[0].canMove(Direction.UP)){
                check3 = true;
            }
            if(check1 ==true && check2==true && check3 ==true){
                square[0].move(Direction.DOWN);
                square[0].move(Direction.LEFT);
                square[3].move(Direction.RIGHT);
                square[3].move(Direction.RIGHT);
                square[2].move(Direction.UP);
                square[2].move(Direction.RIGHT);

                position = 3;
            }
        }

        //rotation 3
        else if(position == 3){
            if(square[0].canMove(Direction.LEFT) && square[1].canMove(Direction.LEFT)){
                check1 = true;
            }
            if(square[3].canMove(Direction.DOWN)){
                check2 =true;
            }
            if(square[0].canMove(Direction.RIGHT)){
                check3=true;
            }
            if(check1==true && check2==true && check3==true){
                square[0].move(Direction.LEFT);
                square[0].move(Direction.UP);
                square[3].move(Direction.DOWN);
                square[3].move(Direction.DOWN);
                square[2].move(Direction.RIGHT);
                square[2].move(Direction.DOWN);

                position = 4;
            }
        }

        //rotation 4
       else if(position ==4){
            if(square[0].canMove(Direction.UP) && square[1].canMove(Direction.UP)){
                check1 = true;
            }
            if(square[3].canMove(Direction.LEFT)){
                check2 = true;
            }
            if(square[0].canMove(Direction.DOWN)){
                check3 = true;
            }
            if(check1==true && check2==true && check3==true){
                square[0].move(Direction.UP);
                square[0].move(Direction.RIGHT);
                square[3].move(Direction.LEFT);
                square[3].move(Direction.LEFT);
                square[2].move(Direction.DOWN);
                square[2].move(Direction.LEFT);

                position = 1;
            }
        }
    }
}
