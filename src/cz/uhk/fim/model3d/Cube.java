package c_03_utery_16_35.model3d;

import transforms.Point3D;

public class Cube extends Solid {

    public Cube(int color) {
        this.color = color;
        vertices.add(new Point3D(-1, -1, 1));
        vertices.add(new Point3D(1, -1, 1));
        vertices.add(new Point3D(1, 1, 1));
        vertices.add(new Point3D(-1, 1, 1));

        vertices.add(new Point3D(-1, -1, -1));
        vertices.add(new Point3D(1, -1, -1));
        vertices.add(new Point3D(1, 1, -1));
        vertices.add(new Point3D(-1, 1, -1));

        indices.add(0); indices.add(1);
        indices.add(1); indices.add(2);
        indices.add(2); indices.add(3);
        indices.add(3); indices.add(0);

        indices.add(4); indices.add(5);
        indices.add(5); indices.add(6);
        indices.add(6); indices.add(7);
        indices.add(7); indices.add(4);

        indices.add(0); indices.add(4);
        indices.add(1); indices.add(5);
        indices.add(2); indices.add(6);
        indices.add(3); indices.add(7);
    }
}
