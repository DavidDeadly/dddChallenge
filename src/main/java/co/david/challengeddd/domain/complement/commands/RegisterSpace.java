package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.Capacity;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.SpaceID;
import co.david.challengeddd.domain.complement.values.SpaceName;

public class RegisterSpace extends Command {

  private final ComplementID complementID;
  private final SpaceID spaceID;
  private final SpaceName spaceName;
  private final Capacity capacity;


  public RegisterSpace(ComplementID complementID, SpaceID spaceID, SpaceName spaceName, Capacity capacity) {
    this.complementID = complementID;
    this.spaceID = spaceID;
    this.spaceName = spaceName;
    this.capacity = capacity;
  }

  public SpaceName getSpaceName() {
    return spaceName;
  }

  public Capacity getCapacity() {
    return capacity;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }
}
