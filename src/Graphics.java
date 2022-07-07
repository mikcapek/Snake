import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Graphics extends JPanel implements ActionListener {
    private Timer t = new Timer(100, this);
    public String state;
    private Snake snake;
    private Food food;
    private Game game;

    // The food and snake objects are public, we are declaring here that we are storing the object
    //why do we need to store it here, can't we just make a reference to it?

    public Graphics(Game g) {
        t.start();
        state = "START";
        game = g;
        snake = g.getPlayer();
        food = g.getFood();
        //add a KeyListener

        this.addKeyListener(game);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }
    public void paintComponent(java.awt.Graphics g) { //same as declaration Graphics graphics? storing of variable?
        //Again why does paintComponent need to take in the imported object, we can't make a reference to it?
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g; //What does this line do (Graphics2D) g?

        g2D.setColor(Color.black); //how does it work, we are setting the color here and again below?
        g2D.fillRect(0, 0, Game.width* Game.dimension, Game.height*Game.dimension);
        //Why is that 0, 0 for x and y
        if(state == "START") {
            g2D.setColor(Color.white);
            g2D.drawString("Press Any Key To Start", Game.width/2 * Game.dimension -40, Game.height/2 * Game.dimension -20);


        } else if(state == "RUNNING") {
        g2D.setColor(Color.red);
        g2D.fillRect(food.getX() * Game.dimension, food.getY() *Game.dimension, Game.dimension, Game.dimension );
        g2D.setColor(Color.green);
        for(Rectangle rectangle : snake.getBody()){ //here we are importing the Rectangle again
            g2D.fill(rectangle);
            }

        } else {
            g2D.setColor(Color.white);
            g2D.drawString("Your Score: " + (snake.getBody().size()-3) + "\n" + "Click any Key to Start a New Game", Game.width/2 * Game.dimension -40, Game.height/2 * Game.dimension -20);
        }





    }


    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); //is this a known function? Where is it defined?
        game.update();

    }


}
