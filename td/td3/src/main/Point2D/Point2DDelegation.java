package Point2D;

import java.awt.Color;

public class Point2DDelegation {
  private ColoredPoint2DInt delegate;
  private int x;
  private int y;

  public Point2DDelegation(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void setDelegate(ColoredPoint2DInt delegate) {
    this.delegate = delegate;
  }

  public void setColor(Color color) {
    delegate.setColor(color);
  }

  public void printColor() {
    delegate.printColor();
  }

  public Point2DDelegation() {
    this.x = 0;
    this.y = 0;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
