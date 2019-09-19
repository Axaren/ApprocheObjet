package fr.ubordeaux.ao;

public class Ellipse implements Shape {
    int x;
    int y;
    int radiusX;
    int radiusY;

    public Ellipse(int x, int y, int radiusX, int radiusY) {
        this.x = x;
        this.y = y;
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public String toSVG() {
        return "<ellipse cx=\"" + x + "\" cy=\"" + y + "\" rx=\"" + radiusX + "\" ry=\"" + radiusY + "\""
            + " style=\"fill:yellow;stroke:black;stroke-width:3\" />";
    }
}