import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Gui extends JPanel {

    static BufferedImage image, image2, imageZoom;
    boolean imageLoaded = false;
    static Color[][] c;
    ImageProcessing imageProcessing;

    public Gui() {
        init();
    }

    public void init() {
        ImageLoad();
        getRGB();

        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);

        JPanel jPanel = new JPanel();
        jPanel.setSize(800, 100);
        jPanel.setLocation(150, 600);


        JButton btnGrayScale = new JButton("Grileştir");
        btnGrayScale.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new GrayScale(c);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JButton btnMirroring = new JButton("Aynalama");
        btnMirroring.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //getRGB();
                imageProcessing = new Mirroring(c);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnNegative = new JButton("Negatif");
        btnNegative.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new Negative(c);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        JButton btnReversing = new JButton("Ters Çevir");
        btnReversing.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing=new Mirroring(c);
                imageProcessing = new Reversing(c);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnShift = new JButton("Ötele");
        btnShift.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new Shift(c, 30, 20);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnZoom = new JButton("ZoomIn In");
        btnZoom.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new ZoomIn(c);
                ImageUpdate();
                getGraphics().drawImage(imageZoom, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnZoomOut = new JButton("ZoomIn Out");
        btnZoomOut.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new ZoomOut(c);
                ImageUpdate();
                getGraphics().drawImage(imageZoom, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnBrightnessUp = new JButton("Parlaklık Arttır");
        btnBrightnessUp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new BrightnessUp(c, 50);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnBrightnessDown = new JButton("Parlaklık Azalt");
        btnBrightnessDown.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new BrightnessDown(c, 50);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnConstrast = new JButton("Karşıtlık");
        btnConstrast.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new Constrast(c, -0.6);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        JButton btnConstrastYayma = new JButton("Karşıtlık Yay");
        btnConstrastYayma.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                imageProcessing = new ConstrastYayma(c);
                ImageUpdate();
                getGraphics().drawImage(image2, 600, 0, null);

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        jFrame.add(jPanel);
        jPanel.add(btnGrayScale);
        jPanel.add(btnMirroring);
        jPanel.add(btnNegative);
        jPanel.add(btnReversing);
        jPanel.add(btnShift);
        jPanel.add(btnZoom);
        jPanel.add(btnZoomOut);
        jPanel.add(btnBrightnessUp);
        jPanel.add(btnBrightnessDown);
        jPanel.add(btnConstrast);
        jPanel.add(btnConstrastYayma);


        jFrame.setSize(1200, 750);
        jFrame.add(this);

    }


    public void ImageLoad() {
        try {
            image = ImageIO.read(new File("cyberpunk.jpg"));
            image2 = ImageIO.read(new File("cyberpunk.jpg"));
            imageLoaded = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ImageUpdate() {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                image2.setRGB(i, j, c[i][j].getRGB());
            }
        }
    }

    public void getRGB() {
        c = new Color[image.getWidth()][image.getHeight()];
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                c[i][j] = new Color(image.getRGB(i, j));
            }
        }
    }


    public void paint(Graphics g) {
        super.paint(g);
        if (imageLoaded) {
            g.drawImage(image, 0, 0, null);
            g.drawImage(image2, 600, 0, null);
            g.drawImage(imageZoom, 600, 0, null);
        }
    }
}
