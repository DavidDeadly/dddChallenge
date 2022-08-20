package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class Age implements ValueObject<Integer> {
  private final Integer value;

  public Age(Integer value) {
    this.value = value;
  }

  @Override
  public Integer value() {
    return null;
  }
}
