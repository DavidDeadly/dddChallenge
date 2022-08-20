package co.david.challengeddd.domain.complement.values;

import co.com.sofka.domain.generic.ValueObject;

public class Ram implements ValueObject<Integer> {
  private final Integer value;

  public Ram(Integer value) {
    this.value = value;
  }


  @Override
  public Integer value() {
    return value;
  }
}
