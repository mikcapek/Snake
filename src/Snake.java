import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Snake {
    private static ArrayList<Rectangle> body;
    private String move;

    public Snake() {
        body = new ArrayList<>();
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation(Game.width / 2 * Game.dimension, Game.height/2 * Game.dimension);
        body.add(temp);
        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2 -1)*Game.dimension, (Game.height/2)*Game.dimension);
        body.add(temp);
        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2 -2)*Game.dimension, (Game.height/2)*Game.dimension);
        body.add(temp);
        move = "Nothing";

    }

    public void resetBody() {
        body.clear();
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation(Game.width / 2 * Game.dimension, Game.height/2 * Game.dimension);
        body.add(temp);
        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2 -1)*Game.dimension, (Game.height/2)*Game.dimension);
        body.add(temp);
        temp = new Rectangle(Game.dimension, Game.dimension);
        temp.setLocation((Game.width/2 -2)*Game.dimension, (Game.height/2)*Game.dimension);
        body.add(temp);
        move = "Nothing";

    }


    // convert UP, DOWN, LEFT, RIGHT to ENUMS
    // check responsibility of each method and which class it should belong to

    public void move() {
        if(move != "Nothing"){
            Rectangle first = body.get(0);
            Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
            if(move == "UP") {
                //should be an ENUM ,equals()
                temp.setLocation(first.x, first.y - Game.dimension);
            } else if(move == "DOWN") {
                temp.setLocation(first.x, first.y + Game.dimension);
            } else if(move == "LEFT") {
                temp.setLocation(first.x - Game.dimension, first.y);
            } else {
                temp.setLocation(first.x + Game.dimension, first.y);
            }
            body.add(0, temp);
            body.remove(body.size()-1);
        }


    }




    public void grow() {
        Rectangle first = body.get(0);
        Rectangle temp = new Rectangle(Game.dimension, Game.dimension);
        if(move == "UP") {
            temp.setLocation(first.x, first.y - Game.dimension);
        } else if(move == "DOWN") {
            temp.setLocation(first.x, first.y + Game.dimension);
        } else if(move == "LEFT") {
            temp.setLocation(first.x - Game.dimension, first.y);
        } else {
            temp.setLocation(first.x + Game.dimension, first.y);
        }
        body.add(0, temp);

    }

    //write a few unit tests, - empty body should return false, body with some links, body with some links and no collision

    public boolean inBody(int x, int y) {
        for(Rectangle link : body) {
            if(link.x == x && link.y == y) {
                return true;
            }
        }
        return false;
    }

    public int linkCount(){
        return body.size();
        }




    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody(ArrayList<Rectangle> body) {
        this.body = body;
    }

    public int getX() {
        return (body.get(0).x);
    }

    public int getY() {
        return (body.get(0).y);

    }


    public void up() {
        move = "UP";
    }
    public void down() {
        move = "DOWN";
    }
    public void left() {
        move = "LEFT";
    }
    public void right() {
        move = "RIGHT";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Snake)) return false;
        Snake snake = (Snake) o;
        return body.equals(snake.body) && move.equals(snake.move);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, move);
    }
}
