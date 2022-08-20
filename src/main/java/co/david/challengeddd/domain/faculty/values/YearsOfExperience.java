package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class YearsOfExperience implements ValueObject<Integer> {

  private final Integer value;

  public YearsOfExperience(Integer value) {
    this.value = value;
  }

  @Override
  public Integer value() {
    return value;
  }
}
