import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;

    public Snake() {
        body = new ArrayList<>();
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation(Game.width / 2 * Game.dimension, Game.height/2 * Game.dimension);
        body.add(temp);
        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2 -1)*Game.dimension, (Game.height/2-1)*Game.dimension);
        body.add(temp);
        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2 -2)*Game.dimension, (Game.height/2-2)*Game.dimension);
        body.add(temp);

    }

    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }
}
