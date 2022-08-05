import java.awt.*;
import java.util.ArrayList;

public class Food {
    private int x;
    private int y;

    public Food(Snake snake) {
        this.random_spawn(snake);

    }

//is x,y inside body
    //remove public getBody
    public void random_spawn(Snake snake) {
       do{
           x = (int)(Math.random() * Game.width - 1);
           y = (int)(Math.random() * Game.height - 1);

       } while (snake.inBody(x, y));
        }








    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
