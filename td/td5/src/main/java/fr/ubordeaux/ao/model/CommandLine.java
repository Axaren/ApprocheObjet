package fr.ubordeaux.ao.model;

import java.util.Objects;

public class CommandLine {
  private final Reference reference;
  private Quantity quantity;

  public CommandLine(Reference reference, int quantity) {
    this.reference = reference;
    this.quantity = new Quantity(quantity);
  }

  public CommandLine(Reference reference) {
    this.reference = reference;
    this.quantity = new Quantity(1);
  }

  public int getPrice() {
    return reference.getBasePrice().getValue() * quantity.getValue();
  }

  public int getQuantity() {
    return quantity.getValue();
  }

  public void setQuantity(int quantity) {
    this.quantity.setValue(quantity);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommandLine that = (CommandLine) o;
    return Objects.equals(getReference(), that.getReference());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getReference());
  }

  public Reference getReference() {
    return reference;
  }
}
