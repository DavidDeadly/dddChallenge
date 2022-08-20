package co.david.challengeddd.domain.complement.commands;

import co.com.sofka.domain.generic.Command;
import co.david.challengeddd.domain.complement.values.ComplementID;
import co.david.challengeddd.domain.complement.values.SpaceID;

public class RegisterSpace extends Command {

  private final ComplementID complementID;
  private final SpaceID spaceID;

  public RegisterSpace(ComplementID complementID, SpaceID spaceID) {
    this.complementID = complementID;
    this.spaceID = spaceID;
  }

  public ComplementID getComplementID() {
    return complementID;
  }

  public SpaceID getSpaceID() {
    return spaceID;
  }
}
