package Point2D;

import java.awt.Color;

public class ColoredPoint2DInheritance extends Point2D {

  private Color rgbColor;

  public ColoredPoint2DInheritance(int x, int y, Color rgbColor) {
    super(x, y);
    this.rgbColor = rgbColor;
  }

  public ColoredPoint2DInheritance(int x, int y) {
    super(x, y);
    this.rgbColor = Color.BLACK;
  }
}
