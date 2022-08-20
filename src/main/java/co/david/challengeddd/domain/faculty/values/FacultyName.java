package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FacultyName implements ValueObject<String> {
  private final String value;

  public FacultyName(String value) {
    String name = Objects.requireNonNull(value);
    if(name.isBlank()) throw new IllegalArgumentException("The faculty name can't be blank");
    this.value = name;
  }

  @Override
  public String value() {
    return value;
  }
}
