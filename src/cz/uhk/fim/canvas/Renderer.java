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
        float k = (y2-y1)/(float)(x2-x1);
        float q = y1-k*x1;
    //problem pro minusove hodnoty, urcit hodnoty
        for(int x=x1;x<=x2;x++){
           int y=Math.round(k*x+q);
           drawPixel(x,y,color);
        }
    }
}
