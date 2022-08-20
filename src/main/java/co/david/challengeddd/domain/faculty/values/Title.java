package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class Title implements ValueObject<String> {
  private final String value;

  public Title(String value) {
    this.value = value;
  }

  @Override
  public String value() {
    return value;
  }
}
