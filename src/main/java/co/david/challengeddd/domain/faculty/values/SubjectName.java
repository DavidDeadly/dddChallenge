package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class SubjectName implements ValueObject<String> {

  private final String value;

  public SubjectName(String value) {
    this.value = value;
  }

  @Override
  public String value() {
    return value;
  }
}
