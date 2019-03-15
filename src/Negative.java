import java.awt.*;

public class Negative implements ImageProcessing{

    public Negative(Color[][] c) {
        Color color;
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                color = new Color(255 - c[i][j].getRed(), 255 - c[i][j].getGreen(), 255 - c[i][j].getBlue());
                c[i][j] = color;
            }
        }
    }
}
