import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    @org.junit.jupiter.api.Test
    void inBody() {
        Snake snake = new Snake();
        assertEquals(true, snake.inBody(Game.width / 2 * Game.dimension, Game.height/2 * Game.dimension));
    }

    @Test
    void linkCount() {
        Snake snake = new Snake();
        assertEquals(7, snake.linkCount());
    }
}