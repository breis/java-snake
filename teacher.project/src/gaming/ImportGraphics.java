package gaming;

import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class ImportGraphics {
    
    public ImportGraphics() {
        
    }

    public BufferedImage getPicture(String pictureName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(pictureName));
        } catch (IOException e) {
            System.out.println("Couldn't find " + pictureName);
        }
        return img;
    }

}
