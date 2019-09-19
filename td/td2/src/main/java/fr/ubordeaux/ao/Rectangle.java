package fr.ubordeaux.ao;

public class Rectangle implements Shape {
    int x;
    int y;
    int width;
    int height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toSVG() {
        return "<rect x=\"" + x + "\" y=\"" + y + "\" width=\"" + width + "\" height=\"" + height + "\""
            + " stroke=\"black\" stroke-width=\"3\" fill=\"red\" />";
    }
}