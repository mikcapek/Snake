import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private Snake player;
    private Food food;
    private JFrame window;
//    import Jframe as window
    private Graphics graphics;

    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;
    //why leaving as final?
    //creating variables

    public Game() {
        window = new JFrame();
//        create new instance of Jframe and store in window
        player = new Snake();
        food = new Food(player);  //What happens when we pass in the player?
        graphics = new Graphics(this);
        window.add(graphics);
        window.setTitle("Snake");
        window.setSize(width*dimension, height*dimension);
        //why is he adding the dimension, why not just 600 by 600??
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public void start() {
        graphics.state = "RUNNING";

    }

    public void update() {
        if(graphics.state == "RUNNING") {
            if(check_food_collision()) {
                player.grow();
                food.random_spawn(player); //why are we passing in the player here?
            } else if (check_wall_collision() || check_self_collision()) {
                graphics.state = "END";
            }
            else {
                player.move();
            }

        }
    }

    private boolean check_wall_collision() {
        if(player.getX() <0 || player.getX() >= width * dimension
                || player.getY() <0 || player.getY() >= width * dimension){
            return true;
        }
            return false;
    }
    private boolean check_food_collision() {
        if(player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) {
            return true;
        }
        return false;
    }

    private boolean check_self_collision() {
        for(int i = 1; i < player.getBody().size(); i++) {
            if(player.getX() == player.getBody().get(i).x &&
                    player.getY() == player.getBody().get(i).y)
            { //Could it not work just by saying if(player.getBody().get(i) == player.getBody().get(i))
                return true;                                              // seems like the same loop
            }

            }
                return false;
            }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        if(graphics.state == "RUNNING") {
            if(KeyCode == KeyEvent.VK_W) {
                player.up();
            } else if (KeyCode == KeyEvent.VK_S) {
                player.down();
            } else if(KeyCode == KeyEvent.VK_A) {
                player.left();
            } else {
                player.right();
            }
        }
        else {
            this.start();
        }
    }

    public Snake getPlayer() {
        return player;
    }

    public void setPlayer(Snake player) {
        this.player = player;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public JFrame getWindow() {
        return window;
    }

    public void setWindow(JFrame window) {
        this.window = window;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}





