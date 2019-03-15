import java.awt.*;

public class BrightnessUp implements Brightness {
    public BrightnessUp(Color[][] colors, int value) {

        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                int red = 255;
                red = ((colors[i][j].getRed() + value) > 255 ? 255 : colors[i][j].getRed() + value);
                int green = 255;
                green = ((colors[i][j].getGreen() + value) > 255 ? 255 : colors[i][j].getGreen() + value);
                int blue = 255;
                blue = ((colors[i][j].getBlue() + value) > 255 ? 255 : colors[i][j].getBlue() + value);
                colors[i][j] = new Color(red, green, blue);
            }
        }

    }
}
