package gaming;

import java.awt.*;
import java.awt.image.*;

public class SimpleGraphics extends Game {

    public SimpleGraphics() {
        super(400, 400, 20);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        MyClass object = new MyClass();

        int[] xArray = {200, 300, 250, 150, 100};
        int[] yArray = {100, 150, 250, 250, 150};

        for (int i = 0; i < 5; i++) {
                xArray[i] -= 100;
                yArray[i] -= 100;
            }
        
        while (true) {
            Color myColor = new Color(object.randomNumber(255),
                    object.randomNumber(255),
                    object.randomNumber(255),
                    object.randomNumber(255));

            g.setColor(myColor);
            g.fillPolygon(xArray, yArray, 5);

            for (int i = 0; i < 5; i++) {
                xArray[i] += 20;
                yArray[i] += 20;
            }
            this.delay(1);
        }

    }

    public void delay(double seconds) {

        int milliseconds;

        milliseconds = (int) seconds * 1000;

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void play() {

        this.gameTitle = "Graphics!";
        this.setUpGame();

    }

}
