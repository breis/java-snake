/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaming;
import java.awt.*;
import java.awt.image.*;

public class GraphicsBackground {
    static public void draw(Graphics g) {
        ImportGraphics importer = new ImportGraphics();
         BufferedImage myPicture = importer.getPicture("strawberry.jpg");

         g.drawImage(myPicture, 100, 100, null);

        
    }
}
