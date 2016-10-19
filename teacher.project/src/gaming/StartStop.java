package gaming;

import java.awt.event.*;

public class StartStop implements KeyListener {

    Game game;
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

     StartStop(Game game) {
        this.game = game;
    }
    
    @Override
    public void keyPressed(KeyEvent event) {
        
        //Pause the game when "space" is pressed
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {
            if (game.gameTimer.isRunning()) {
                game.gameTimer.stop();
            } else {
                game.gameTimer.start();
            }
        } 
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
