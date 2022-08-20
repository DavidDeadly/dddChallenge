package co.david.challengeddd.domain.complement.values;

import co.com.sofka.domain.generic.ValueObject;

public class Capacity implements ValueObject<Integer> {

  private final Integer value;

  public Capacity(Integer value) {
    this.value = value;
  }
  @Override
  public Integer value() {
    return value;
  }
}
