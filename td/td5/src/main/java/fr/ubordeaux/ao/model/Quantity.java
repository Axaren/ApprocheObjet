package fr.ubordeaux.ao.model;

import fr.ubordeaux.ao.model.exception.QuantityException;
import java.util.Objects;

public class Quantity {

  private int value;

  public Quantity(int value) {
    setValue(value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getValue());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Quantity quantity = (Quantity) o;
    return getValue() == quantity.getValue();
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    if (value <= 0)
      throw new QuantityException("Quantity must not be less than 1");
    this.value = value;
  }
}
