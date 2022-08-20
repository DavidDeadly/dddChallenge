package co.david.challengeddd.domain.complement.values;

import co.com.sofka.domain.generic.ValueObject;

public class TypeOfSpace implements ValueObject<TypeOfSpaceE> {
  public TypeOfSpace(TypeOfSpaceE value) {
    this.value = value;
  }

  private final TypeOfSpaceE value;

  @Override
  public TypeOfSpaceE value() {
    return value;
  }
}
