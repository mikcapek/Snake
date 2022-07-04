import javax.swing.*;
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
        window.setTitle("Snake");
        window.setSize(width*dimension, height*dimension);
        //why is he adding the dimension, why not just 600 by 600??
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
