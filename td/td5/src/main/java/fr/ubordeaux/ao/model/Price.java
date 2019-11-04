package fr.ubordeaux.ao.model;

import fr.ubordeaux.ao.model.exception.NegativePriceException;
import java.util.Objects;

public class Price {

  private final int valueInEuroCents;

  public Price(int valueInEuroCents) {
    if (valueInEuroCents < 0) {
      throw new NegativePriceException("A price cannot be negtive");
    }
    this.valueInEuroCents = valueInEuroCents;
  }

  public int getValue() {
    return valueInEuroCents;
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueInEuroCents);
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Price)) {
      return false;
    }
    return this.valueInEuroCents == ((Price) other).valueInEuroCents;
  }

  @Override
  public String toString() {
    return String.valueOf(this.valueInEuroCents);
  }
}
