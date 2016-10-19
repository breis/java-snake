package gaming;

import java.awt.*;

public class SnakeBackground {

    boolean mapped = false;

    private void map(Snake s) {

        for (int i = 0; i < s.numberOfTilesWide; i++) {
            for (int j = 0; j < s.numberOfTilesHigh; j++) {
                if (i == 0 || i == (s.numberOfTilesWide - 1) || j == 0 || j == (s.numberOfTilesHigh - 1)) {
                    s.gameTileSet.setObstacle(i, j);
                }
            }
        }

    }

   public void draw(Graphics g, Snake s) {

        if (mapped == false) {
            map(s);
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 500);
        }
        mapped = true;

        for (int i = 0; i < s.numberOfTilesWide; i++) {
            for (int j = 0; j < s.numberOfTilesHigh; j++) {
                if (s.gameTileSet.isObstacle(i, j)) {
                    g.setColor(Color.black);
                } else if (s.gameTileSet.isReward(i, j)) {
                    g.setColor(Color.red);
                } else if (s.gameTileSet.isBody(i, j)) {
                    g.setColor(Color.blue);
                } else {
                    g.setColor(Color.lightGray);
                }
                g.fillRect(i * s.tileSize + s.tilePadding, j * s.tileSize + s.tilePadding, s.snakeWidth, s.snakeHeight);
            }
        }
    }

}
