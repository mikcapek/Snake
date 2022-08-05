import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game implements KeyListener {

    private JFrame window;
    private Snake snake;
    private Food food;
    private Graphics graphics;
    public static final int width = 30;
    public static final int height = 30;
    public static final int dimension = 20;


    public Game() {

        window = new JFrame();

        snake = new Snake();

        food = new Food(snake);

        graphics = new Graphics(this);

        window.add(graphics);
        window.setTitle("Snake");
        window.setSize(width * dimension + 2, height * dimension + dimension + 4);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void start() {
        graphics.state = Graphics.states.RUNNING;
    }

    public void update() {

        if(graphics.state == Graphics.states.RUNNING) {
            if(check_food_collision()) {
                snake.grow();
                food.random_spawn(snake);
                graphics.getT().setDelay(graphics.delay -= 1);
                System.out.println(graphics.getT().getDelay());

            } else if (check_wall_collision() || check_self_collision()) {
                graphics.state = Graphics.states.END;
                graphics.getT().setDelay(graphics.delay);

            } else {
                snake.move();
            }

        }
    }

    public void restart() {
            window.getContentPane().invalidate();
            window.getContentPane().revalidate();
            window.getContentPane().repaint();
            graphics.setDelay(100);
            snake.resetBody();
            food.random_spawn(snake);
            graphics.state = Graphics.states.START;

    }


    private boolean check_wall_collision() {
        if(snake.getX() <0 || snake.getX() >= width * dimension
                || snake.getY() <0 || snake.getY() >= width * dimension){
            return true;
        }
            return false;
    }
    private boolean check_food_collision() {
        if(snake.getX() == food.getX() * dimension && snake.getY() == food.getY() * dimension) {
            return true;
        }
        return false;
    }

    //move method to Snake,

    private boolean check_self_collision() {
        for(int i = 1; i < snake.getBody().size(); i++) {
            if(snake.getX() == snake.getBody().get(i).x &&
                    snake.getY() == snake.getBody().get(i).y)
            {
                return true;
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
        if (graphics.state == Graphics.states.RUNNING) {
            if(KeyCode == KeyEvent.VK_W) {
                snake.up();
            } else if (KeyCode == KeyEvent.VK_S) {
                snake.down();
            } else if(KeyCode == KeyEvent.VK_A) {
                snake.left();
            } else {
                snake.right();
            }
        } else if(graphics.state == Graphics.states.END) {
            if(KeyCode == KeyEvent.VK_W) {
                restart();
            }
        } else {
            this.start();
        }
    }

    public Snake getPlayer() {
        return snake;
    }

    public void setPlayer(Snake player) {
        this.snake   = player;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}





