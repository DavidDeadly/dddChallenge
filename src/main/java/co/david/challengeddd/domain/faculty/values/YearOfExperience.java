package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class YearOfExperience implements ValueObject<Integer> {

  private final Integer value;

  public YearOfExperience(Integer value) {
    this.value = value;
  }

  @Override
  public Integer value() {
    return value;
  }
}
