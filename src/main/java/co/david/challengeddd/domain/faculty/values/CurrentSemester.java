package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

public class CurrentSemester implements ValueObject<Integer> {

  private final Integer value;

  public CurrentSemester(Integer value) {
    this.value = value;
  }

  @Override
  public Integer value() {
    return value;
  }
}
