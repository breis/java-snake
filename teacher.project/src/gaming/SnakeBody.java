package gaming;

public class SnakeBody {

    // Position of the snake body part
    int xPos;
    int yPos;

    // The part behind the current snake body part
    SnakeBody previousPart;
    TileSet snakeTileSet;

    public SnakeBody(TileSet snakeTileSet, int xPosition, int yPosition) {
        this.xPos = xPosition;
        this.yPos = yPosition;
        this.snakeTileSet = snakeTileSet;
    }

    /**
     * The addPart method adds a part of the snake body to the snake
     *
     * @param newX  the x position the snake should be moved to
     * @param newY  the y position the snake should be moved to
     */
    public void moveSnake(int newX, int newY) {

        int tempX = this.xPos;
        int tempY = this.yPos;

        this.snakeTileSet.setNormal(this.xPos, this.yPos);
        this.xPos = newX;
        this.yPos = newY;
        this.snakeTileSet.setBody(newX, newY);

        // Move the rest of the snake
        if (this.previousPart != null) {
            this.previousPart.moveSnake(tempX, tempY);
        }

    }

    /**
     * The addPart method adds a part of the snake body to the snake
     *
     * @param xPosition the x position where the part should be added
     * @param yPosition the y position where the part should be added
     */
    public void addPart(int xPosition, int yPosition) {
        if (this.previousPart != null) {
            previousPart.addPart(this.xPos, this.yPos);
        } else {
            this.previousPart = new SnakeBody(this.snakeTileSet, this.xPos, this.yPos);
        }
    }

}
