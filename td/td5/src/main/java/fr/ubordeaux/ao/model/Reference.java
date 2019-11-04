package fr.ubordeaux.ao.model;

import fr.ubordeaux.ao.model.exception.ReferenceManagementException;
import java.util.Objects;

public class Reference {

  private static final int MAX_NAME_LENGTH = 20;
  private static final int MAX_DESC_LENGTH = 200;

  private final ReferenceID id;
  private final String name;
  private final String description;
  private final Price basePrice;

  public Reference(ReferenceID id, String name, String description,
      Price basePrice) {
    this.id = id;

    if (name.length() <= 0 || name.length() > MAX_NAME_LENGTH) {
      throw new ReferenceManagementException("Reference name must be between 1 and "
          + MAX_NAME_LENGTH + " characters");
    }
    this.name = name;

    if (description.length() > MAX_DESC_LENGTH) {
      throw new ReferenceManagementException("Reference description must be shorter"
          + " than " + MAX_DESC_LENGTH + " characters");
    }
    this.description = description;

    this.basePrice = basePrice;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getDescription(), getBasePrice());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Reference reference = (Reference) o;
    return getId().equals(reference.getId()) &&
        getName().equals(reference.getName()) &&
        Objects.equals(getDescription(), reference.getDescription()) &&
        getBasePrice().equals(reference.getBasePrice());
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Price getBasePrice() {
    return basePrice;
  }

  public ReferenceID getId() {
    return id;
  }
}
