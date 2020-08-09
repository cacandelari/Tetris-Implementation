import java.awt.*;

public interface PieceInterface
{
    public void draw(Graphics g);

    public void move(Direction direction);

    public Point[] getLocations();

    public Color getColor();

    public boolean canMove(Direction direction);

    public void rotate();
}
