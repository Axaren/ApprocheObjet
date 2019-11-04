package fr.ubordeaux.ao.model.exception;

public class NegativePriceException extends RuntimeException {

  public NegativePriceException(String message) {
    super(message);
  }
}
