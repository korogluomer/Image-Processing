import java.awt.*;

public class Shift implements ImageProcessing{

    public Shift(Color[][] c, int en, int boy) {

        for (int i = c.length - en - 1; i > -1; i--) {
            for (int j = c[i].length - boy - 1; j > -1; j--) {
                c[i + en][j + boy] = c[i][j];
            }
        }
        for (int i = 0; i < en; i++) {
            for (int j = 0; j < c.length; j++) {
                c[i][j] = new Color(0, 0, 0);
            }
        }
        for (int i = 0; i < boy; i++) {
            for (int j = 0; j < c.length; j++) {
                c[j][i] = new Color(0, 0, 0);
            }
        }
    }
}
