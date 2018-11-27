package cz.uhk.fim.model;

/**
 * @author David Sladecek
 */
public class Line {
    private int x1, y1, x2, y2;
    private int length;

    public Line(Pixel start, Pixel end) {
        this.x1 = start.x;
        this.x2 = end.x;
        this.y1 = start.y;
        this.y2 = end.y;
        setLength();
    }

    public int getLength() {
        return length;
    }

    /**
     * count length of line
     */
    public void setLength() {
        int x = x2 - x1;
        int y = y2 - y1;
        this.length = (int) Math.sqrt(x * x + y * y);
    }

    public boolean isHorizontal(){
        //TODO y1=y2
        return false;
    }

    public  void orientate(){
        //TODO prohozeni pokud y1>y2
    }

    public boolean intersectionExists(int y) {
        // TODO y, y1, y2
        return false;
    }

    public int getIntersection(int y) {
        // TODO vypočítat průsečík pomocí y, k, q (osa Y)
        return 0;
    }

    public boolean isInside(Pixel p){
        Pixel t = new Pixel(x2-x1,y2-y1);
        Pixel n = new Pixel(t.y,-t.x);
        Pixel v = new Pixel(p.x-x1,p.y-y1);

        return (n.x*v.x+n.y*v.y<0);
    }

    public Pixel getIntersection(Pixel v1, Pixel v2){

        float x0 = ((v1.x * v2.y - v1.y * v2.x) * (x1 - x2) - (x1 * y2 - y1 * x2) * (v1.x - v2.x))
                / (float) ((v1.x - v2.x) * (y1 - y2) - (x1 - x2) * (v1.y - v2.y));
        float y0 = ((v1.x * v2.y - v1.y * v2.x) * (y1 - y2) - (x1 * y2 - y1 * x2) * (v1.y - v2.y))
                / (float) ((v1.x - v2.x) * (y1 - y2) - (x1 - x2) * (v1.y - v2.y));
        return new Pixel(Math.round(x0), Math.round(y0));
    }


}
