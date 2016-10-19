package gaming;

import java.awt.event.*;

public class MoveSnake implements ActionListener {

    // The snake game we're using with our MoveSnake object
    Snake snakeGame;

    /**
     * The MoveSnake constructor makes sure that when we make a MoveSnake
     * object, we tell it what Snake object we're using with it.
     *
     * @param game the Snake game the MoveSnake object is being used with
     */
    public MoveSnake(Snake game) {
        this.snakeGame = game;
    }

    /**
     * When an Action happens (in this case, the timer "ticking"), the
     * actionPerformed method calculates where to move the snake, and then
     * updates the background to show where the snake moved.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // The changes to make to the snake's location
        int changeInColumn;
        int changeInRow;

        // Where the snake was
        int oldColumnLocation;
        int oldRowLocation;

        // Where the snake needs to move
        int newColumnLocation;
        int newRowLocation;

        // We have to get where the snake is from the snake object
        oldColumnLocation = snakeGame.snakeColumnLocation;
        oldRowLocation = snakeGame.snakeRowLocation;

        // Calculates the change based on the direction
        if (snakeGame.direction == Direction.UP) {
            changeInColumn = 0;
            changeInRow = -1;
        } else if (snakeGame.direction == Direction.LEFT) {
            changeInColumn = -1;
            changeInRow = 0;
        } else if (snakeGame.direction == Direction.RIGHT) {
            changeInColumn = 1;
            changeInRow = 0;
        } else {
            changeInColumn = 0;
            changeInRow = 1;
        }

        // Find where to move the snake
        newColumnLocation = oldColumnLocation + changeInColumn;
        newRowLocation = oldRowLocation + changeInRow;

        // Set the snake's location to the new location
        snakeGame.snakeColumnLocation = newColumnLocation;
        snakeGame.snakeRowLocation = newRowLocation;

        // Check if the snake encountered an obstacle
        if (snakeGame.gameTileSet.isObstacle(newColumnLocation, newRowLocation)
                || snakeGame.gameTileSet.isBody(newColumnLocation, newRowLocation)) {
            snakeGame.gameOver();
        // Check if the snake encountered a reward
        } else if (snakeGame.gameTileSet.isReward(newColumnLocation, newRowLocation)) {
            
            snakeGame.snakeHead.moveSnake(newColumnLocation, newRowLocation);
            snakeGame.snakeHead.addPart(oldColumnLocation, oldRowLocation);
            snakeGame.gameTileSet.setRandomReward();
            snakeGame.paintBackground();
        } else {
            snakeGame.snakeHead.moveSnake(newColumnLocation, newRowLocation);
            snakeGame.paintBackground();
        }

    }

}
