package cz.uhk.fim.canvas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public class Renderer {

    private BufferedImage img;
    private Canvas canvas;
    private static final int FPS = 1000/30;

    public Renderer(BufferedImage img, Canvas canvas) {
        this.img = img;
        this.canvas = canvas;
        setTimer();
    }

    private void setTimer() {
        //časovač, který 30 za vteřinu obnovi obsah platna
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // říct plátnu, aby zobrazil aktuální img
                canvas.getGraphics().drawImage(img, 0, 0, null);
                // co dělá observer - https://stackoverflow.com/a/1684476
            }
        },0,FPS);
    }

    public void clear(){
        Graphics g = img.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,600);
    }

    public void drawPixel(int x, int y, int color) {
        // nastavit pixel do img
        img.setRGB(x, y, color);
    }

    public void drawLine (int x1, int y1, int x2, int y2,int color){
        float k = (y2 - y1) / (float) (x2 - x1);
        // https://www.google.com/search?q=java+dividing+two+integers
        float q = y1 - k * x1;

        // řídící osa X
        if (Math.abs(k) < 1) {
            if (x1 > x2) {
                int a = x1;
                x1 = x2;
                x2 = a;

                a = y1;
                y1 = y2;
                y2 = a;
            }

            for (int x = x1; x <= x2; x++) {
                int y = Math.round(k * x + q);
                drawPixel(x, y, color);
            }
        } else {
            if (x2 < x1) {
                int a = x2;
                x2 = x1;
                x1 = a;

                a = y2;
                y2 = y1;
                y1 = a;
            }
            for (int x = x1; x < x2; x++) {
                int y = (int) (k * x + q);
                drawPixel(x, y, color);
            }

        }
    }

    public void drawLineDda(int x1,int y1, int x2, int y2, int color) {
        float dx = x2 - x1;
        float dy = y2 - y1;

        if (Math.abs(y2 - y1) <= Math.abs(x2 - x1)) {

            if ((x1 == x2) && (y1 == y2)) {
                drawPixel(x1, y1, color);

            } else {
                if (x2 < x1) {
                    int tmp = x2;
                    x2 = x1;
                    x1 = tmp;

                    tmp = y2;
                    y1 = tmp;
                }

                float k = dy / dx;
                float y = y1;

                for (int x = x1; x <= x2; x++) {

                    drawPixel(x, Math.round(y), color);
                    y += k;
                }
            }
        } else {

            if (y2 < y1) {
                int tmp = x2;
                x1 = tmp;

                tmp = y2;
                y2 = y1;
                y1 = tmp;
            }

            float k = dx / dy;
            float x = x1;
            for (int y = y1; y <= y2; y++) {

                drawPixel(Math.round(x), y, color);
                x += k;
            }

        }
    }
}
