package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class TotalHours implements ValueObject<Integer> {

  private final Integer value;

  public TotalHours(Integer value) {
    this.value = value;
  }

  @Override
  public Integer value() {
    return value;
  }
}
