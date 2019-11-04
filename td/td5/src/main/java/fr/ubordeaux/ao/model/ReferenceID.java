package fr.ubordeaux.ao.model;

import java.util.UUID;

public class ReferenceID {
  private final String refId;

  private ReferenceID(String refId) {
    this.refId = refId;
  }

  public static ReferenceID generateReferenceID(String id) {
    UUID uuid = UUID.fromString(id);
    String generatedID = Long.toString(uuid.getMostSignificantBits(), 94) + '-' + Long.toString(uuid.getLeastSignificantBits(), 94);
    return new ReferenceID(generatedID);
  }

  public String getID() {
    return refId;
  }
}
