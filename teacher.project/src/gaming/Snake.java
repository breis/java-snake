package gaming;

import javax.swing.*;

public class Snake extends Game {

    /* The number of the column the snake is in
     * Columns are numbered from left to right, 1 2 3 4 5 6 7
     */
    int snakeColumnLocation;

    /* The number of the row the snake is in
     * Rows are numbered from top to bottom,
     1
     2
     3
     4
     5
     6
     */
    int snakeRowLocation;

    // The width of the snake in pixels
    int snakeWidth;

    // The height of the snake in pixels
    int snakeHeight;

    // The amount of white space between tiles
    int tilePadding;

    // Affect how fast the snake will move
    int speedMultiplier;
    int speed;
    
    // Counts how many apples the snake has eaten
    int applesEaten;

    // Whether or not the game has ended
    boolean gameOver;

    // The part of the snake body at the front
    SnakeBody snakeHead;

    // The graphics of the whole game
    SnakeBackground background;

    // The actionListener that moves the snake
    MoveSnake snakeMover;

    // The actionListener that starts and stops the game
    StartStop playPauseListener;

    // The actionListener that changes the direction of the snake
    ChangeDirection directionChanger;

    /**
     * Constructs a Snake Game.
     *
     * The width of the game will be 400 pixels, the height will be 400 pixels,
     * and the size of the tiles will be 20 pixels by 20 pixels.
     *
     */
    public Snake() {
        super(400, 400, 20);
    }

    /**
     * The calculateSnakeXPosition method calculates the x value of where to
     * draw the snake in pixel measurements, based on its current column
     * location.
     *
     * @return The x position, in pixels, of the snake
     */
    public int calculateSnakeXPosition() {
        int snakeX = tileSize * snakeColumnLocation + 1;
        return snakeX;
    }

    /**
     * The calculateSnakeYPosition method calculates the y value of where to
     * draw the snake in pixel measurements, based on its current row location.
     *
     * @return The y position, in pixels, of the snake
     */
    public int calculateSnakeYPosition() {
        int snakeY = tileSize * snakeRowLocation + 1;
        return snakeY;
    }

    /**
     * The gameOver method is called when the game ends.
     *
     */
    public void gameOver() {
        
        gameTimer.stop();
        gameGraphics.clearRect(0, 0, 400, 400);
        gameGraphics.drawString("YOU LOSE", 200, 200);
        
    }

    /**
     * The play method sets up the whole game before it starts.
     *
     */
    @Override
    public void play() {

        // Call the setUpGame method that is in the Game class.
        this.setUpGame();

        // The direction starts off as down
        direction = Direction.DOWN;

        // And we would hope the game isn't over when we started!
        gameOver = false;

        // This is the position where the snake starts
        snakeColumnLocation = 10;
        snakeRowLocation = 1;

        // This is how many pixels of space we want to see between the tiles
        // Since each tile gets its own "perimeter" of space, the space between
        // them will always be double this number
        tilePadding = 1;

        // The width and height of the snake in pixels
        snakeWidth = tileSize - tilePadding * 2;
        snakeHeight = tileSize - tilePadding * 2;

        // Increase the speedMultiplier to increase the speed of the snake
        speedMultiplier = 10;
        speed = 1000 / speedMultiplier;

        // Initialize our actionListener object that will move the snake
        snakeMover = new MoveSnake(this);

        // Initialize the timer object that will say when to move the snake
        gameTimer = new Timer(speed, snakeMover);

        // Initialize our object that will tell the game when to start
        playPauseListener = new StartStop(this);

        // Initialize our object that will change the snake's direction when the
        // keys are pressed.
        directionChanger = new ChangeDirection(this);

        // The graphics of the game
        background = new SnakeBackground();

        // The front of the snake
        snakeHead = new SnakeBody(gameTileSet, snakeColumnLocation, snakeRowLocation);

        // Both the playPauseListener and the directionChanger are a kind of
        // object that we call "Action Listeners." For the game to pay
        // attention to them, we not only have to initialize them, but we
        // also have to use a method to "add" them to the game.
        // (The snakeMover was already added with the timer)
        this.addKeyListener(playPauseListener);
        this.addKeyListener(directionChanger);
        
        gameGraphics.drawString("Press Space to start", 200, 200);
       
        // Put down the first apple
        gameTileSet.setRandomReward();

    }

    /**
     * The paintBackground method makes sure that Java updates our graphics to
     * reflect any changes!
     *
     */
    public void paintBackground() {
        background.draw(this.gameGraphics, this);
    }
}
