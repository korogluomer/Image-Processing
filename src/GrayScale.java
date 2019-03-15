import java.awt.*;
import java.awt.image.BufferedImage;

public class GrayScale implements ImageProcessing{
    public GrayScale(Color[][] c) {
        for (int i = 0; i < c.length; i++) {

            for (int j = 0; j < c[i].length; j++) {

                Color c2 = new Color(c[i][j].getRGB());
                int red = (int) (c2.getRed() * 0.299);
                int green = (int) (c2.getGreen() * 0.587);
                int blue = (int) (c2.getBlue() * 0.114);
                c[i][j] = new Color(red + green + blue,red + green + blue, red + green + blue);

            }
        }
    }
}
