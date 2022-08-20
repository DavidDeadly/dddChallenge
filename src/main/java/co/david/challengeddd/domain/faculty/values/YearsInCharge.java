package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class YearsInCharge implements ValueObject<Integer> {

  private final Integer value;

  public YearsInCharge(Integer value) {
    this.value = value;
  }

  @Override
  public Integer value() {
    return value;
  }
}
