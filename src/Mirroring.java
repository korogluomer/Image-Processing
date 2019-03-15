import java.awt.*;

public class Mirroring implements ImageProcessing {

    public Mirroring(Color[][] c) {
        Color[][] temp = new Color[1][c[0].length];
        for (int i = 0; i < c.length / 2; i++) {
            temp[0] = c[i];
            c[i] = c[c.length - i - 1];
            c[c.length - i - 1] = temp[0];
        }
    }
}
