package cz.uhk.fim.model;

import java.util.ArrayList;
import java.util.List;


/**
 * @author David Sladecek
 */
public class Polygon {
    private int numberOfVertexes;
    private List<Pixel> vertexes;
    private float radius;
    private Pixel center;
    private int angle;

    public Polygon() {
        this.numberOfVertexes = 0;
        this.vertexes = new ArrayList();
    }


    public void setCenter(Pixel center) {
        this.center = center;
    }

    public int getAngle() {
        return angle;
    }


    public void setAngle(int angle) {
        this.angle = angle;
    }

    /**
     * Method counts angle of regular polygon. If angle is higher than 120 set to 120 - draw triangle
     * @param a line used for compute angle of regular polygon
     * @return angle of regular polygon
     */
    public int countAngle(Line a) {
        double radians = Math.asin(a.getLength() / (2 * radius));
        int tmp = 2 * (int) Math.toDegrees(radians);
        if (tmp > 120) {
            tmp = 120;
        }
        return tmp;
    }

    /**
     * add vertex to polygon
     * @param x x coordination of new vertex
     * @param y y coordination of new vertex
     * @param color color of new vertex
     */
    public void addVertex(int x, int y, int color) {
        Pixel newPixel = new Pixel(x, y);
        this.vertexes.add(newPixel);
        numberOfVertexes++;
    }


    public int getNumberOfVertexes() {
        return numberOfVertexes;
    }

    /**
     * method used for set number of vertexes and round of angle
     */
    public void setNumberOfVertexes() {
        int v = 360 / getAngle();
        if (v < 3) {
            v = 3;
        }
        setNumberOfVertexes(v);
        setAngle(360 / numberOfVertexes);
    }

    /**
     * set number of vertexes and round angle
     * @param n number of vertexes
     */
    public void setNumberOfVertexes(int n) {
        this.numberOfVertexes = n;
        setAngle(360 / n);
    }

    public Pixel getVertexOnIndex(int index) {
        return vertexes.get(index);
    }


    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * form regular polygon according to angle, direction and number of vertexes
     */
    public void formRegularPolygon() {
        vertexes = new ArrayList<>();
        setNumberOfVertexes();
        for (int i = 0; i < numberOfVertexes; i++) {
            vertexes.add(new Pixel((int) (center.getX() + radius * Math.cos(i * Math.toRadians(angle))),
                    (int) (center.getY() + radius * Math.sin(i * Math.toRadians(angle)))));
        }
    }

    /**
     * form triangle using first vertex of regular polygon
     * @param x x coordination of triangle vertex
     * @param y y coordination of triangle vertex
     */
    public void formRegularPolygon(int x, int y) {
        vertexes = new ArrayList<>();
        setNumberOfVertexes(3);
        for (int i = 0; i < numberOfVertexes; i++) {
            vertexes.add(new Pixel((int) (center.getX() + radius * Math.cos(i * Math.toRadians(angle))),
                    (int) (center.getY() + radius * Math.sin(i * Math.toRadians(angle)))));
        }

    }


}