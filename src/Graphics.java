import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {


    public int delay = 100;
    private Timer t = new Timer(delay, this);
    public states state;
    private Snake snake;
    private Food food;
    private Game game;



    public enum states {
        START, RUNNING, END
    }

    public void setDelay(int delay) {
        this.delay = delay;

    }

    public void setT(Timer t) {
        this.t = t;
    }

    public Timer getT() {
        return t;
    }

    public Graphics(Game g) {
        t.start();
        state = states.START;
        game = g;
        snake = g.getPlayer();
        food = g.getFood();
        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.black);
        g2D.fillRect(0, 0, Game.width* Game.dimension, Game.height*Game.dimension);
        if(state == states.START) {
            g2D.setColor(Color.white);
            g2D.drawString("Press Any Key To Start", Game.width/2 * Game.dimension -40, Game.height/2 * Game.dimension -20);


        } else if(state == states.RUNNING) {
            g2D.setColor(Color.red);
            g2D.fillRect(food.getX() * Game.dimension, food.getY() *Game.dimension, Game.dimension, Game.dimension );
            g2D.setColor(Color.green);
            for(Rectangle rectangle : snake.getBody()){ //here we are importing the Rectangle again
                g2D.fill(rectangle);
                }
            g2D.setColor(Color.white);
            g2D.drawString("Your Score: " + (snake.getBody().size()-3), Game.width/2 * Game.dimension -40, Game.height/2 * Game.dimension -20);

        } else  {
            g2D.setColor(Color.white);
            g2D.drawString("Your Score: " + (snake.getBody().size()-3) + "\n" + "Click any Key to Start a New Game", Game.width/2 * Game.dimension - 140, Game.height/2 * Game.dimension);
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        game.update();

    }




}
