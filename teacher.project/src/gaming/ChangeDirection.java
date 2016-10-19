package gaming;

import java.awt.event.*;

public class ChangeDirection implements KeyListener {

    Snake game;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public ChangeDirection(Snake game) {
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent event) {

        if (event.getKeyCode() == KeyEvent.VK_UP) {
            
            game.direction = Direction.UP;
            
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN) {

            game.direction = Direction.DOWN;
            
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT) {

            game.direction = Direction.LEFT;
            
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            
            game.direction = Direction.RIGHT;
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
