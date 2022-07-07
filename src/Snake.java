import java.awt.*;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Rectangle> body;
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

    public void move() {
        if(move != "Nothing"){
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

        //how is this growing?

    }
    public ArrayList<Rectangle> getBody() {
        return body;
    }

    public void setBody() {
        this.body = body;
    }

    public int getX() {
        return (body.get(0).x);
    }

    public int getY() {
        return (body.get(0).y); //we always have to declare and return a type?

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

}
