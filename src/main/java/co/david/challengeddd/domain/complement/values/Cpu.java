package co.david.challengeddd.domain.complement.values;

import co.com.sofka.domain.generic.ValueObject;

public class Cpu implements ValueObject<String> {
  private final String value;

  public Cpu(String value) {
    this.value = value;
  }


  @Override
  public String value() {
    return value;
  }
}
