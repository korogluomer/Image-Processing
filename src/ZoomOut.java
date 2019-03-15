import java.awt.*;
import java.awt.image.BufferedImage;

public class ZoomOut implements Zoom {
    public ZoomOut(Color[][] colors) {
        System.out.println((colors.length / 2) + (colors.length % 2) + " " + colors[0].length);
        Color[][] c2 = new Color[(colors.length / 2) + (colors.length % 2)][(colors[0].length / 2) + (colors[0].length % 2)];
        for (int i = 0; i < colors.length / 2; i++) {
            for (int j = 0; j < colors[0].length / 2; j++) {
                c2[i][j] = new Color((colors[i * 2][j * 2].getRed() + colors[i * 2][j * 2 + 1].getRed() + colors[i * 2 + 1][j * 2].getRed() + colors[i * 2 + 1][j * 2 + 1].getRed()) / 4,
                        (colors[i * 2][j * 2].getGreen() + colors[i * 2][j * 2 + 1].getGreen() + colors[i * 2 + 1][j * 2].getGreen() + colors[i * 2 + 1][j * 2 + 1].getGreen()) / 4,
                        (colors[i * 2][j * 2].getBlue() + colors[i * 2][j * 2 + 1].getBlue() + colors[i * 2 + 1][j * 2].getBlue() + colors[i * 2 + 1][j * 2 + 1].getBlue()) / 4);
            }
        }

        Gui.imageZoom = new BufferedImage(c2.length, c2[0].length, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < c2.length; i++) {
            for (int j = 0; j < c2[i].length; j++) {
                if (c2[i][j] == null)
                    c2[i][j] = new Color(0, 0, 0);
                Gui.imageZoom.setRGB(i, j, c2[i][j].getRGB());
            }
        }
    }
}
