/**
 * Create and control the game Tetris.
 *
 *
 *
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tetris extends JPanel {

    private Game game;
    private int FinalScore;

    /**
     * Sets up the parts for the Tetris game, display and user control
     */
    public Tetris() {
        game = new Game(this);
        JFrame f = new JFrame("TETRIS");
        f.add(this);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(407, 550);
        f.setVisible(true);
        EventController ec = new EventController(game);
        f.addKeyListener(ec);
        setBackground(Color.CYAN);
    }

    /**
     * Updates the display
     */
    public void update() {
        repaint();
    }

    /**
     * Paint the current state of the game
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.draw(g);
        if (game.isGameOver()) {
            FinalScore = game.getEndScore();

            //System.out.println(FinalScore);

            g.setFont(new Font("Palatino", Font.BOLD, 40));
            g.setColor(Color.BLACK);
            g.drawString("GAME OVER", 80, 300);
            g.drawString("Score: " + FinalScore, 80, 45);

        }
    }

    public static void main(String[] args)
    {

        JFrame frame = new JFrame("Welcome to TETRIS!");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,300);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JButton StartButton = new JButton("Start Game");
        StartButton.setBounds(90,100,100,50);

        JButton ControlsButton = new JButton("Controls");
        ControlsButton.setBounds(190,100,100,50);

        JLabel Title = new JLabel("TETRIS!");
        Title.setFont(new Font("Palatino", Font.BOLD, 40));

        Title.setBounds(115,20,300,60);


        panel.add(Title);
        panel.add(StartButton);
        panel.add(ControlsButton);

        StartButton.addActionListener(new StartGame());
        ControlsButton.addActionListener(new ControlsMenu());


        //new Tetris();
        frame.setVisible(true);
    }

}

class StartGame implements ActionListener{
    public void actionPerformed(ActionEvent e){
        new Tetris();
    }

}

class ControlsMenu implements ActionListener{
    public void actionPerformed(ActionEvent e){
        JFrame Controlframe = new JFrame("Controls Menu");
        Controlframe.setResizable(false);

        Controlframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Controlframe.setSize(900,350);

        JPanel ControlPanel = new JPanel();
        ControlPanel.setLayout(null);

        Controlframe.add(ControlPanel);

        JLabel Movement = new JLabel("Use the Left, Down, and Right arrow keys, or the A, S, and D keys to move the Tetris piece Left, Down, and Right respectively.");
        Movement.setBounds(10,10,800,20);

        JLabel Rotation = new JLabel("Use Space or Shift to rotate the Tetris piece. (But be aware of sticky keys if using shift!)");
        Rotation.setBounds(10,40,800,20);

        JLabel Scoring = new JLabel("Score Calculation:");
        Scoring.setBounds(10, 70, 700, 20);

        JLabel ScoreFormula = new JLabel("Score = 100 + (100 X n - (n - 2)) + ... + (100 X n - 1) + (100 X n) where n is greater than 0, does not equal 1, and is the number of rows removed at once.");
        ScoreFormula.setBounds(10,90,850,20);

        JLabel ScoreExample = new JLabel("For example, removing 2 rows at once will get you 300 points. 100 for removing 1 row plus 200 more for removing 2 at once.");
        ScoreExample.setBounds(10,110,800,20);

        JLabel ExitLine = new JLabel("Please exit this window when done reading.");
        ExitLine.setBounds(250,200,700,20);

        JLabel Enjoy = new JLabel("Good luck, and enjoy playing TETRIS!");
        Enjoy.setBounds(250,220,700,20);

        ControlPanel.add(Movement);
        ControlPanel.add(Rotation);
        ControlPanel.add(Scoring);
        ControlPanel.add(ScoreFormula);
        ControlPanel.add(ScoreExample);
        ControlPanel.add(ExitLine);
        ControlPanel.add(Enjoy);


        Controlframe.setVisible(true);
    }
}