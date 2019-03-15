import java.awt.*;

public class Constrast implements ImageProcessing{

    public Constrast(Color[][] colors, double value) {
        System.out.println(value);
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                int result = (int) (value * 255);
                int red = ((colors[i][j].getRed() + result) < 0 ? 0 : ((colors[i][j].getRed() + result) > 255 ? 255 : colors[i][j].getRed() + result));
                int green = ((colors[i][j].getGreen() + result) < 0 ? 0 : ((colors[i][j].getGreen() + result) > 255 ? 255 : colors[i][j].getGreen() + result));
                int blue = ((colors[i][j].getBlue() + result) < 0 ? 0 : ((colors[i][j].getBlue() + result) > 255 ? 255 : colors[i][j].getBlue() + result));
                colors[i][j] = new Color(red, green, blue);
            }
        }
    }
}
