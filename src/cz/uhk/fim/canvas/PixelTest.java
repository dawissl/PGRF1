package cz.uhk.fim.canvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class PixelTest {

    private JFrame window;
    private BufferedImage img; // objekt pro zápis pixelů
    private Canvas canvas; // plátno pro vykreslení BufferedImage
    private Renderer renderer;

    public PixelTest() {
        window = new JFrame();
        // bez tohoto nastavení se okno zavře, ale aplikace stále běží na pozadí
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 600); // velikost okna
        window.setLocationRelativeTo(null);// vycentrovat okno
        window.setTitle("PGRF1 cvičení"); // titulek okna

        // inicializace image, nastavení rozměrů (nastavení typu - pro nás nedůležité)
        img = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);

        // inicializace plátna, do kterého budeme kreslit img
        canvas = new Canvas();

        window.add(canvas); // vložit plátno do okna
        window.setVisible(true); // zorabzit okno
        renderer = new Renderer(img,canvas); //nova instance rendereru

        renderer.drawPixel(100, 50, Color.GREEN.getRGB());
        //renderer.drawLine(50,10,400,50,Color.RED.getRGB());
        // 0x00ff00 == Color.GREEN.getRGB()

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                renderer.drawPixel(e.getX(), e.getY(), Color.yellow.getRGB());
            }
        });

        canvas.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                renderer.clear();
                renderer.drawLineDda(100,100,e.getX(),e.getY(),Color.BLUE.getRGB());
            }
        });




    }



    public static void main(String[] args) {
        SwingUtilities.invokeLater(PixelTest::new);
        // https://www.google.com/search?q=SwingUtilities.invokeLater
        // https://www.javamex.com/tutorials/threads/invokelater.shtml
        // https://www.google.com/search?q=java+double+colon
    }
}