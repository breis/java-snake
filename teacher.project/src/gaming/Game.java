package gaming;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

abstract class Game extends Frame {

    // What the game window is called
    String gameTitle;

    // A special object used by the Java graphics engine
    Graphics gameGraphics;

    // Graphics offset to account for window padding
    final int xOffset = 8;
    final int yOffset = 30;

    int gameWidth;
    int gameHeight;
    int tileSize;

    int numberOfTilesWide;
    int numberOfTilesHigh;

    Timer gameTimer;

    TileSet gameTileSet;

    Direction direction;

    boolean unpainted;

    public Game(int width, int height, int size) {
        this.gameWidth = width;
        this.gameHeight = height;
        this.tileSize = size;

        numberOfTilesWide = gameWidth / tileSize;
        numberOfTilesHigh = gameHeight / tileSize;

        gameTileSet = new TileSet(numberOfTilesWide, numberOfTilesHigh);
    }

    public void setUpGame() {
        // Make the frame
        this.setSize(gameWidth + xOffset * 2, gameHeight + yOffset + xOffset);
        this.setTitle(gameTitle);
        this.setVisible(true);
        unpainted = true;
        gameGraphics = this.getGraphics();
        this.setIgnoreRepaint(true);
        gameGraphics.translate(xOffset, yOffset);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public void paint(Graphics g) {
        if (unpainted) {
            g.translate(xOffset, yOffset);
            unpainted = false;
        } else {
        }

    }

    public abstract void play();

}
