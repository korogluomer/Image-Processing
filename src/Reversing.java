import java.awt.*;

public class Reversing implements ImageProcessing{

    public Reversing(Color[][] c) {
        Color[][] temp = new Color[1][c[0].length];
        for (int i = 0; i < c.length; i++) {
            for (int j=0;j<c[i].length/2;j++){
                temp[0][j] = c[i][j];
                c[i][j]= c[i][c.length-j-1];
                c[i][c.length-j-1] = temp[0][j];
            }

        }
    }
}
