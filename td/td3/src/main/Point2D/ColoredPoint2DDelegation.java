package Point2D;

import java.awt.Color;

public class ColoredPoint2DDelegation implements ColoredPoint2DInt {
  private Color color;

  @Override
  public void printColor() {
    System.out.println(color.toString());
  }

  @Override
  public void setColor(Color color) {
    this.color = color;
  }

  @Override
  public Color getColor() {
    return color;
  }
}
