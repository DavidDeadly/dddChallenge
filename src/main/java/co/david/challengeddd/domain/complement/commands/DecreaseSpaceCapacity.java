package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.Capacity;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class DecreaseSpaceCapacity extends Command {
  private final ComplementID complementID;
  private final SpaceID spaceID;
  private final Capacity capacity;

  public DecreaseSpaceCapacity(ComplementID complementID, SpaceID spaceID, Capacity capacity) {
    this.complementID = complementID;
    this.spaceID = spaceID;
    this.capacity = capacity;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }

  public Capacity getCapacity() {
    return capacity;
  }
}
