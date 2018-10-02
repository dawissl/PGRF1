package cz.uhk.fim.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PixelTest {

    private JFrame window; //main window
    private BufferedImage img;//drawed image
    private JPanel panel; //panel used for drawing

    public PixelTest() {
        //basic for creating window
        window = new JFrame();
        window.setSize(1366,768);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        //create panel and insert into the window
       panel = new JPanel();
       window.add(panel);
        //create image - pixel
       img = new BufferedImage(1366,768,BufferedImage.TYPE_INT_RGB);


      // drawPixel(20,120, Color.magenta.getRGB());

       panel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               drawPixel(e.getX(),e.getY(),Color.magenta.getRGB());
           }
       });
    }


    private void drawPixel(int x, int y, int colour){
        img.setRGB(x,y,colour);
        panel.getGraphics().drawImage(img,0,0,null);

    }

    public static void main(String[] args) {
        new PixelTest();
    }

}
