package co.david.challengeddd.domain.faculty.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ActiveYears implements ValueObject<Integer> {
  private final Integer value;

  public ActiveYears(Integer value) {
    this.value = Objects.requireNonNull(value);
  }

  @Override
  public Integer value() {
    return value;
  }
}
