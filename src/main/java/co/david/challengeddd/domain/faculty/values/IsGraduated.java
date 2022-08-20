package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class IsGraduated implements ValueObject<Boolean> {

  private final Boolean value;

  public IsGraduated(Boolean value) {
    this.value = value;
  }

  @Override
  public Boolean value() {
    return value;
  }
}
