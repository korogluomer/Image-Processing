import java.awt.*;

public class BrightnessDown implements Brightness {
    public BrightnessDown(Color[][] colors, int value) {


        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                int red,green,blue;
                red = ((colors[i][j].getRed() - value) < 0 ? 0 : colors[i][j].getRed() - value);
                green = ((colors[i][j].getGreen() - value) < 0 ? 0 : colors[i][j].getGreen() - value);
                blue = ((colors[i][j].getBlue() - value) < 0 ? 0 : colors[i][j].getBlue() - value);
                colors[i][j] = new Color(red, green, blue);
            }
        }
    }
}
