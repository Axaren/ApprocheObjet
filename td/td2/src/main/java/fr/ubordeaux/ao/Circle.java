package fr.ubordeaux.ao;

public class Circle implements Shape {
    int centerX;
    int centerY;
    int radius;

    public Circle(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public String toSVG() {
        return "<circle cx=\"" + centerX + "\" cy=\"" + centerY + "\" r=\"" + radius + "\""
            + " stroke=\"black\" stroke-width=\"3\" fill=\"red\" />";
    }
}