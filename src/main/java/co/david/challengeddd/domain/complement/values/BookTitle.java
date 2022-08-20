package co.david.challengeddd.domain.complement.values;

import co.com.sofka.domain.generic.ValueObject;

public class BookTitle implements ValueObject<String> {
  private final String value;

  public BookTitle(String value) {
    this.value = value;
  }

  @Override
  public String value() {
    return value;
  }
}
