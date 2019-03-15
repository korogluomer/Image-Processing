import java.awt.*;
import java.awt.image.BufferedImage;

public class ZoomIn implements Zoom {

    public ZoomIn(Color[][] c) {
        Color[][] c2 = new Color[c.length + (c.length - 1)][c[0].length + (c[0].length - 1)];
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                c2[2 * i][2 * j] = c[i][j];
            }
        }
        for (int i = 0; i < c2.length; i += 2) {
            for (int j = 1; j < c2[0].length; j += 2) {
                c2[i][j] = new Color((c2[i][j - 1].getRed() + c2[i][j + 1].getRed()) / 2,
                        (c2[i][j - 1].getGreen() + c2[i][j + 1].getGreen()) / 2,
                        (c2[i][j - 1].getBlue() + c2[i][j + 1].getBlue()) / 2);
            }
        }

        for (int i = 1; i < c2.length; i += 2) {
            for (int j = 0; j < c2[0].length; j++) {
                c2[i][j] = new Color((c2[i - 1][j].getRed() + c2[i + 1][j].getRed()) / 2,
                        (c2[i - 1][j].getGreen() + c2[i + 1][j].getGreen()) / 2,
                        (c2[i - 1][j].getBlue() + c2[i + 1][j].getBlue()) / 2);
            }
        }

        Gui.imageZoom = new BufferedImage(c2.length, c2[0].length, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < c2.length; i++) {
            for (int j = 0; j < c2[i].length; j++) {
                Gui.imageZoom.setRGB(i, j, c2[i][j].getRGB());
            }
        }
    }
}
