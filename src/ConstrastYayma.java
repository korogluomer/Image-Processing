import java.awt.*;

public class ConstrastYayma implements ImageProcessing {
    public ConstrastYayma(Color[][] colors) {
        int buyuk = -16777216, kucuk = -1;
        Color buyukC, kucukC;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                if (buyuk < colors[i][j].getRGB()) {
                    buyuk = colors[i][j].getRGB();
                }
                if (kucuk > colors[i][j].getRGB()) {
                    kucuk = colors[i][j].getRGB();
                }
            }
        }
        buyukC = new Color(buyuk);
        kucukC = new Color(kucuk);
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {

                int red = (colors[i][j].getRed() - kucukC.getRed()) / (buyukC.getRed() - kucukC.getRed()) * 255;
                int green = (colors[i][j].getGreen() - kucukC.getGreen()) / (buyukC.getGreen() - kucukC.getGreen()) * 255;
                int blue = (colors[i][j].getBlue() - kucukC.getBlue()) / (buyukC.getBlue() - kucukC.getBlue()) * 255;

                colors[i][j] = new Color(red, green, blue);

            }
        }

    }
}
